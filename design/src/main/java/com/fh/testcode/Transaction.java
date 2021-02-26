package com.fh.testcode;

public class Transaction {

    private String id;
    private Long buyerId;
    private Long sellerId;
    private Long productId;
    private String orderId;
    private Long createTimestamp;
    private Double amount;
    private STATUS status;
    private String walletTransactionId;

    private WalletRpcService walletRpcService;
    private TransactionLock lock;

    //类的创建--通过依赖注入的方式
    public void setWalletRpcService(WalletRpcService walletRpcService){
        this.walletRpcService = walletRpcService;
    }

    public void setTransationLock(TransactionLock lock){
        this.lock = lock;
    }

    public Transaction(String preAssignedId,Long buyerId,Long sellerId,Long productId,String orderId){
        if(preAssignedId != null && !preAssignedId.isEmpty()){
            this.id = preAssignedId;
        }else {
            this.id = IdGenerator.generateTransactionId();
        }
        if(!this.id.startsWith("t_")){
            this.id = "t_"+preAssignedId;
        }
        this.buyerId = buyerId;
        this.sellerId = sellerId;
        this.productId = productId;
        this.orderId = orderId;
        this.status = STATUS.TO_BE_EXECUTD;
        this.createTimestamp = System.currentTimeMillis();
    }

    public boolean execute() throws InvalidTransactionException {
        if (buyerId == null || sellerId == null || amount < 0.0){
            throw new InvalidTransactionException("无效拉");
        }
        if(status == STATUS.EXECUTED){
            return true;
        }
        boolean isLocked = false;
        try {
            isLocked = lock.lock(id);
            if(!isLocked){
                return false;
            }
            if(status == STATUS.EXECUTED){
                return true;
            }
            //long executionInvokedTimestamp  = System.currentTimeMillis();
            if(isExpired()){
                this.status = STATUS.EXPIRED;
                return false;
            }
            //代码重构,创建交给上层逻辑注入
//            WalletRpcService  walletRpcService = new WalletRpcService();
            String wallerId = walletRpcService.moveMoney(id, buyerId, sellerId, amount);
            if(wallerId != null){
                this.walletTransactionId = wallerId;
                this.status = STATUS.EXECUTED;
                return true;
            }else {
                this.status = STATUS.FAILED;
                return false;
            }

        } finally {
            if(isLocked){
                lock.unlock(id);
            }
        }

    }

    //提取代码
    protected boolean isExpired(){
        long executionInvokedTimestamp  = System.currentTimeMillis();
        return executionInvokedTimestamp - createTimestamp > 14 * 24 * 60 * 60 * 1000;
    }
}
