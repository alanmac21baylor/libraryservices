package com.lmsbooks.events.source;

import com.lmsbooks.events.model.BookChangeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.stereotype.Component;
import org.springframework.messaging.support.MessageBuilder;


@Component
public class BookChangeSource {
    private final Source source;

    @Autowired
    public BookChangeSource(Source source){
        this.source = source;
    }

    public void publishBookChange(String action, Long bookId){
        BookChangeModel change = new BookChangeModel(
                BookChangeModel.class.getTypeName(),
                action,
                bookId
        );
        source.output().send(MessageBuilder.withPayload(change).build());
    }
}
