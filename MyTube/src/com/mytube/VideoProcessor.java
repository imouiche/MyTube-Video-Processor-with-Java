package com.mytube;

public class VideoProcessor {
    private VideoEncoder encoder;
    private VideoDatabase database;
    private EmailService notificationSender;

    public VideoProcessor(
            VideoEncoder encoder,
            VideoDatabase database,
            EmailService notificationSender) {
        this.encoder = encoder;
        this.database = database;
        this.notificationSender = notificationSender;
    }

    public void process(Video video) {
       // var encoder = new ClassVideoEncoder(); //instantiation not allowed after we declare interface
        encoder.encode(video);

        //var database = new ClassVideoDatabase();
        database.store(video);

        //var emailService = new ClassEmailService();
        notificationSender.sendEmail(video.getUser());
    }
}
