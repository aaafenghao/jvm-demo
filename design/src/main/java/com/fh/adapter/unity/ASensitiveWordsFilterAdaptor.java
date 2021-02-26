package com.fh.adapter.unity;

public class ASensitiveWordsFilterAdaptor implements ISensitiveWordsFilter {

    private ASensitiveWordsFilter filter;

    @Override
    public String filter(String text) {
        return filter.filterSexyWords(text);
    }
}
