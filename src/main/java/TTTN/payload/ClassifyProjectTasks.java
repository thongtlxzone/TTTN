package TTTN.payload;

import TTTN.dto.TaskDTO;

import java.util.ArrayList;
import java.util.List;

public class ClassifyProjectTasks {
    private List<TaskDTO> toDoList = new ArrayList<>();
    private List<TaskDTO> doneList = new ArrayList<>();

    public List<TaskDTO> getToDoList() {
        return toDoList;
    }

    public void setToDoList(List<TaskDTO> toDoList) {
        this.toDoList = toDoList;
    }

    public List<TaskDTO> getDoneList() {
        return doneList;
    }

    public void setDoneList(List<TaskDTO> doneList) {
        this.doneList = doneList;
    }
}
