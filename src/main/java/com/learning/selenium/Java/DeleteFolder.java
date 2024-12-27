package com.learning.selenium.Java;



	import java.io.File;

	public class DeleteFolder {
	    public static void main(String[] args) {
	        // Specify the folder path
	        String folderPath = System.getProperty("user.dir") + "//reports";

	        // Create a File object
	        File folder = new File(folderPath);

	        // Call the deleteFolder method
	        if (deleteFolder(folder)) {
	            System.out.println("Folder deleted successfully!");
	        } else {
	            System.out.println("Failed to delete the folder.");
	        }
	    }

	    // Recursive method to delete a folder and its contents
	    public static boolean deleteFolder(File folder) {
	        if (!folder.exists()) {
	            System.out.println("Folder does not exist.");
	            return false;
	        }

	        // If it's a directory, delete its contents first
	        if (folder.isDirectory()) {
	            File[] files = folder.listFiles();
	            if (files != null) {
	                for (File file : files) {
	                    // Recursive call to delete subfolders and files
	                    deleteFolder(file);
	                }
	            }
	        }

	        // Delete the folder or file
	        return folder.delete();
	    }
	}
