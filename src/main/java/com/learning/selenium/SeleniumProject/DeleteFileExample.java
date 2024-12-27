package com.learning.selenium.SeleniumProject;

import java.io.File;

public class DeleteFileExample {
    public static void main(String[] args) throws InterruptedException {
        // Specify the file to be deleted
        File file = new File(System.getProperty("user.dir") + "//reports//index.html");

        Thread.sleep(6000);
        // Check if the file exists before attempting to delete
        if (file.exists()) {
            boolean deleted = file.delete(); // Attempt to delete the file
            if (deleted) {
                System.out.println("File deleted successfully.");
            } else {
                System.out.println("Failed to delete the file.");
            }
        } else {
            System.out.println("File does not exist.");
        }
    }
}