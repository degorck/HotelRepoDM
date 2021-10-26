package com.example.demo.utils.observer;

import static com.example.demo.utils.Constants.BLANK_SPACE;
import static com.example.demo.utils.Constants.WAS_NOTIFIED;

import com.example.demo.dto.request.NewDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NewsSubscriber implements Subscriber{
    private String email;
    private NewDTO news;

    @Override
    public void update(Object news) {
        this.setNews((NewDTO) news);
        System.out.println(this.email.concat(BLANK_SPACE).concat(WAS_NOTIFIED));
    }
}
