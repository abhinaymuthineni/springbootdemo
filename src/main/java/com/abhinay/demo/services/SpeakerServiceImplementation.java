package com.abhinay.demo.services;

import com.abhinay.demo.entity.Speakers;
import com.abhinay.demo.repository.SpeakersRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpeakerServiceImplementation implements SpeakerService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private SpeakersRepository speakersRepository;


    @Override
    public List<Speakers> listSpeakers() {
        return speakersRepository.findAll();
    }

    @Override
    public Speakers getSpeakerById(int id) {
        Optional<Speakers> result = Optional.of(speakersRepository.getById(id));

        return result.get();
    }

    @Override
    public Speakers saveSpeaker(Speakers speaker) {

        speakersRepository.save(speaker);
        return speaker;
    }

    @Override
    public void deleteSpeaker(int id) {

        speakersRepository.deleteById(id);
    }
}
