package com.fh.vw.domain;

import com.fh.vw.exception.InsufficientBalanceException;
import com.fh.vw.exception.InvalidAmountException;

import java.math.BigDecimal;

/**
 * Domain领域模型--充血模型
 */
public class VirtualWallet {

    private Long id;
    private Long createTime = System.currentTimeMillis();
    private BigDecimal balance = BigDecimal.ZERO;

    private boolean isAllowedOverdraft = true;
    private BigDecimal overdraftAmount = BigDecimal.ZERO;
    private BigDecimal frozenAmount = BigDecimal.ZERO;

    public VirtualWallet(Long preAllocateId){
        this.id = preAllocateId;
    }

    public void freeze(BigDecimal amount){

    }
    public void unfreeze(BigDecimal amount){

    }
    public void increaseOverdraftAmount(BigDecimal amount){

    }
    public void decreaseOverdraftAmount(BigDecimal amount){

    }
    public void closeOverdraft(){

    }
    public void openOverdraft(){

    }

    public BigDecimal getAvailableBalance(){
        BigDecimal subtract = this.balance.subtract(frozenAmount);
        if(isAllowedOverdraft){
            subtract.add(this.overdraftAmount);
        }
        return subtract;
    }


    public BigDecimal balance(){
        return this.balance;
    }

    //扣款
    public void debit(BigDecimal amount){
        if(this.balance.compareTo(amount) < 0){
          throw new InsufficientBalanceException("金额异常");
        }
        this.balance = this.balance.subtract(amount);
    }

    //贷方
    public void credit(BigDecimal amount){
        if(this.balance.compareTo(amount) < 0){
            throw new InvalidAmountException("金额异常");
        }
        this.balance.add(amount);
    }
}
