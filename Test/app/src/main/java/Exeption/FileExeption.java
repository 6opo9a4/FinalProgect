package Exeption;

public class FileExeption extends Exception {

        private String file;
        public String getNumber(){return file;}
        public FileExeption(String message, String File){

            super(message);
            file=File;
        }

}
