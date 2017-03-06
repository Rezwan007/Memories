package net.deviac.memories.Model;

/**
 * Created by SUMIT on 1/16/2017.
 */

public class MemoryModel {
    private int memoryId;
    private String memoryTitle;
    private String memoryDescription;
    private String memoryImage;
    private String memoryDate;

    public MemoryModel(int memoryId, String memoryTitle, String memoryDescription, String memoryImage, String memoryDate) {
        this.memoryId = memoryId;
        this.memoryTitle = memoryTitle;
        this.memoryDescription = memoryDescription;
        this.memoryImage = memoryImage;
        this.memoryDate = memoryDate;
    }

    public MemoryModel(String memoryTitle, String memoryDescription, String memoryImage, String memoryDate) {
        this.memoryTitle = memoryTitle;
        this.memoryDescription = memoryDescription;
        this.memoryImage = memoryImage;
        this.memoryDate = memoryDate;
    }

    public MemoryModel(String memoryTitle, String memoryDescription, String memoryDate) {
        this.memoryTitle = memoryTitle;
        this.memoryDescription = memoryDescription;
        this.memoryDate = memoryDate;
    }

    public MemoryModel(){}

    public int getMemoryId() { return memoryId; }

    public String getMemoryTitle() {
        return memoryTitle;
    }

    public String getMemoryDescription() {
        return memoryDescription;
    }

    public String getMemoryImage() {
        return memoryImage;
    }

    public String getMemoryDate() {
        return memoryDate;
    }
}
