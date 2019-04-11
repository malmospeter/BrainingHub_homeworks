package pmnotes.documents;

import pmnotes.files.Files;

public class Notes extends Document {

    private String content;
    private int attachedFileID;
    private String attachedFileName;

    public Notes(String name, String content) {
        super(name);
        this.content = content;
    }
    
    public Notes(String name, String content, Files file) {
        super(name);
        this.content = content;
        this.attachedFileID=file.getId();
        this.attachedFileName=file.getName();
    }

    public void attachFile(Files file){
        setAttachedFileID(file.getId());
        setAttachedFileName(file.getName());
    }
    
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getAttachedFileID() {
        return attachedFileID;
    }

    private void setAttachedFileID(int idOfAttachedFile) {
        this.attachedFileID = idOfAttachedFile;
    }

    public String getAttachedFileName() {
        return attachedFileName;
    }

    private void setAttachedFileName(String nameOfAttachedFile) {
        this.attachedFileName = nameOfAttachedFile;
    }
    
    

    @Override
    public String toString() {
        return super.toString() + " content=" + content + " attachedFile id=" +attachedFileID + " name=" + attachedFileName;
    }

}
