package com.fh.vw.repository;

import com.fh.vw.entity.VirtualWalletEntity;

import java.math.BigDecimal;

public class VirtualWalletRepository {

    public VirtualWalletEntity getWalletEntity(Long walledId){
        return null;
    }

    public BigDecimal getBalace(Long walletId){
        return new BigDecimal(walletId);
    }

    public void updateBalance(Long id,BigDecimal amount){
        //
    }
}
