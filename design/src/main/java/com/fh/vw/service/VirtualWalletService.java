package com.fh.vw.service;

import com.fh.vw.domain.VirtualWallet;
import com.fh.vw.entity.VirtualWalletEntity;
import com.fh.vw.repository.VirtualWalletRepository;
import com.fh.vw.repository.VirtualWalletTransactionRepository;

import java.math.BigDecimal;

public class VirtualWalletService {

    private VirtualWalletRepository virtualWalletRepository;
    private VirtualWalletTransactionRepository virtualWalletTransactionRepository;

    public VirtualWallet getVirtualWallet(Long walletId){
        VirtualWalletEntity walletEntity = virtualWalletRepository.getWalletEntity(walletId);
        VirtualWallet convert = convert(walletEntity);
        return convert;
    }

    public BigDecimal getBalance(Long walletId){
        return virtualWalletRepository.getBalace(walletId);
    }

    public void debit(Long walletId,BigDecimal amount){
        VirtualWalletEntity walletEntity = virtualWalletRepository.getWalletEntity(walletId);
        VirtualWallet convert = convert(walletEntity);
        convert.debit(amount);
        virtualWalletRepository.updateBalance(walletId,convert.balance());
    }

    public void credit(Long walletId,BigDecimal amount){
        VirtualWalletEntity walletEntity = virtualWalletRepository.getWalletEntity(walletId);
        VirtualWallet convert = convert(walletEntity);
        convert.credit(amount);
        virtualWalletRepository.updateBalance(walletId,convert.balance());
    }

    private VirtualWallet convert(VirtualWalletEntity entity){
        return new VirtualWallet(entity.getId());
    }
}
