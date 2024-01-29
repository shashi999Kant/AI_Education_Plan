package com.exam.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.model.exams.LearningItem;
import com.exam.repo.LearningItemRepository;

@Service
public class LearningItemService {

    @Autowired
    private LearningItemRepository learningItemRepository;

    public LearningItem saveLearningItem(LearningItem learningItem) {
        return learningItemRepository.save(learningItem);
    }

    public LearningItem getLearningItemById(Long itemId) {
        return learningItemRepository.findById(itemId).orElse(null);
    }


}
