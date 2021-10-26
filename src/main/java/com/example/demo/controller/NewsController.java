package com.example.demo.controller;

import com.example.demo.dto.ResponseDTO;
import com.example.demo.dto.SubscribersDTO;
import com.example.demo.dto.request.NewDTO;
import com.example.demo.service.NewsService;
import com.example.demo.service.SubscribersService;
import com.example.demo.utils.Constants;
import com.example.demo.utils.aspect.TrackExecutionTime;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.example.demo.utils.Constants.NEWS_SENT;

@RestController
@RequestMapping(value = "news")
public class NewsController {
    @Autowired
    NewsService newsService;

    @Autowired
    SubscribersService subscribersService;

    @Operation(summary="Post news")
    @PostMapping(value = "/send")
    @TrackExecutionTime
    public ResponseEntity<ResponseDTO<String>> sendNews(@RequestBody NewDTO newDTO){
        newsService.sendNews(newDTO);
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstant.SUCCESS.getDescription(), NEWS_SENT);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @Operation(summary="Subscribe to newsletter")
    @PutMapping(value = "/subscribe")
    @TrackExecutionTime
    public ResponseEntity<ResponseDTO<SubscribersDTO>> createSubscriber(@Valid  @RequestBody SubscribersDTO subscribersDTO){
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstant.SUCCESS.getDescription(), subscribersService.createSubscriber(subscribersDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
