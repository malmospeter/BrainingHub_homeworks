
package pmnotes.files;

import pmnotes.documents.Document;

public class Files extends Document {
    
    public Files(String name) {
        super(name);
    }
    
    public static <T extends Files> Files uploadFile(int input, String name) throws Exception{
        switch (input){
            case 1: return new PDF(name);
            case 2: return new Video(name);
            case 3: return new Voice(name);
        }
        throw new Exception("Upload failed!");
    }
    
    public static <T extends Files> void openFile(T f){
        System.out.println("I am opened!");
        System.out.println(f.toString());
    }
    

    @Override
    public String toString() {
        return super.toString();
    }
    
    
}
