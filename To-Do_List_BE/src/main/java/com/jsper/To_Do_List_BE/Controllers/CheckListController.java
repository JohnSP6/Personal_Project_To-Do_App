package com.jsper.To_Do_List_BE.Controllers;

import com.jsper.To_Do_List_BE.Models.CheckList;
import com.jsper.To_Do_List_BE.Services.CheckListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/checklists")
public class CheckListController {

    @Autowired
    private CheckListService checkListService;

    @GetMapping
    public List<CheckList> getAllCheckLists(){
        return checkListService.getAllCheckLists();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<CheckList>> getCheckListsByUserId(@PathVariable String userId){
        List<CheckList> checkLists = checkListService.getAllCheckListsByUserId(userId);
        if(checkLists.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(checkLists);
    }

    @PostMapping
    public ResponseEntity<CheckList> createCheckList(@RequestBody CheckList checkList){
        CheckList createdCheckList = checkListService.createChekList(checkList);
        return ResponseEntity.ok(createdCheckList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCheckListById(@PathVariable String id){
        checkListService.deleteCheckList(id);
        return ResponseEntity.noContent().build();
    }

}
