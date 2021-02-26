package com.fh.reconfig.first;

import com.fh.reconfig.abnormal.IdGenerationFailureException;

import java.net.UnknownHostException;

public interface IdGenerator {

    String generator() throws IdGenerationFailureException;
}
