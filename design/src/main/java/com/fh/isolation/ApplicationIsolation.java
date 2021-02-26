package com.fh.isolation;


public class ApplicationIsolation {

    static ConfigSource configSource = new ZookeeperConfigSource();
    public static final RedisConfig redisConfig = new RedisConfig(configSource);
    public static final KafkaConfig kafkaConfig = new KafkaConfig(configSource);
    public static final MysqlConfig mysqlConfig = new MysqlConfig(configSource);

    public static void main(String[] args) {
        //redis热更新
        ScheduledUpdater redisConfigUpdater = new ScheduledUpdater(redisConfig,300,300);
        redisConfigUpdater.run();

        ScheduledUpdater kafkaConfigUpdater = new ScheduledUpdater(kafkaConfig,10,10);
        kafkaConfigUpdater.run();

        SimpleHttpServer simpleHttpServer = new SimpleHttpServer("",200);
        simpleHttpServer.addViews("",redisConfig);
        simpleHttpServer.addViews("",mysqlConfig);

    }
}
