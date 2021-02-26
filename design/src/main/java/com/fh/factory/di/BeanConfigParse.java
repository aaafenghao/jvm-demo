package com.fh.factory.di;

import java.io.InputStream;
import java.util.List;

public interface BeanConfigParse {

    List<BeanDefinition> parse(InputStream inputStream);

    List<BeanDefinition> parse(String configContent);
}
