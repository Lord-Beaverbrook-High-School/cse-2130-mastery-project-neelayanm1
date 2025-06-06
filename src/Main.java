public class Main {
    public static void main(String[] args) {
        String rawPath = "/workspaces/cse-2130-mastery-project-neelayanm1/src/data_raw.txt";
        String compressedPath = "/workspaces/cse-2130-mastery-project-neelayanm1/src/data_compressed.txt";
        String decompressedPath = "data_decompressed.txt";

        Compressor.compressFile(rawPath, compressedPath);
        Compressor.decompressFile(compressedPath, decompressedPath);
    }
}