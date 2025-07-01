package com.jsper.To_Do_List_BE.Services;

import com.jsper.To_Do_List_BE.Models.CheckList;
import com.jsper.To_Do_List_BE.Repositories.CheckListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CheckListService {

    @Autowired
    private CheckListRepository checkListRepository;

    public List<CheckList> getAllCheckLists(){
        return checkListRepository.findAll();
    }

    public List<CheckList> getAllCheckListsByUserId(String userId){
        return checkListRepository.findAllCheckListsByUserId(userId);
    }

    public Optional<CheckList> getCheckListById(String id){
        return checkListRepository.findById(id);
    }

    public CheckList createChekList(CheckList checkList){

        checkList.setCreatedDate(LocalDateTime.now());
        return checkListRepository.save(checkList);
    }

    public void deleteCheckList(String id){
        checkListRepository.deleteById(id);
    }

}
