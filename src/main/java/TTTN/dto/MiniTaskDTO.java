package TTTN.dto;

public class MiniTaskDTO {
    private int id;
    private int miniTaskName;
    private int description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMiniTaskName() {
        return miniTaskName;
    }

    public void setMiniTaskName(int miniTaskName) {
        this.miniTaskName = miniTaskName;
    }

    public int getDescription() {
        return description;
    }

    public void setDescription(int description) {
        this.description = description;
    }
}
