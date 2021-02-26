package com.fh.statistics;

public class PerfCounterTest {

    public static void main(String[] args) {
        MetricsStorage storage = new RedisMetricsStorage();
        Aggregator aggregator = new Aggregator();

        ConsoleViewer consoleViewer = new ConsoleViewer();
        ConsoleReporter consoleReporter = new ConsoleReporter(storage,aggregator,consoleViewer);
        consoleReporter.startRepeatedReport(60,60);

        EmailViewer emailViewer = new EmailViewer();
        emailViewer.addToAddress("");
        EmailReporter emailReporter = new EmailReporter(storage,new EmailSender(),aggregator,emailViewer);
        emailReporter.startDailyReport();

        MetricsCollector collector = new MetricsCollector(storage);
        collector.recordRequest(new RequestInfo());
        collector.recordRequest(new RequestInfo());
        collector.recordRequest(new RequestInfo());
        collector.recordRequest(new RequestInfo());
        collector.recordRequest(new RequestInfo());
        collector.recordRequest(new RequestInfo());
        collector.recordRequest(new RequestInfo());

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
