import java.io.*;
import java.util.*;

public class BinaryCompressor {

    /**
     * Compresses a binary file using run-length encoding.
     * For example: 1 1 1 0 0 → 1 3 0 2
     *
     * @param inputFilename  path to the raw data file
     * @param outputFilename path to save compressed data
     */
    public static void compressFile(String inputFilename, String outputFilename) {
        try (Scanner scanner = new Scanner(new File(inputFilename));
             PrintWriter writer = new PrintWriter(new File(outputFilename))) {

            if (!scanner.hasNext()) {
                System.out.println("Input file is empty.");
                return;
            }

            String current = scanner.next();
            int count = 1;

            while (scanner.hasNext()) {
                String next = scanner.next();
                if (next.equals(current)) {
                    count++;
                } else {
                    writer.print(current + " " + count + " ");
                    current = next;
                    count = 1;
                }
            }

            // Write last group
            writer.print(current + " " + count);

            System.out.println("Compression completed successfully.");

        } catch (IOException e) {
            System.err.println("Error processing file: " + e.getMessage());
        }
    }

    /**
     * Decompresses a run-length encoded binary file.
     * For example: 1 3 0 2 → 1 1 1 0 0
     *
     * @param inputFilename  path to the compressed data file
     * @param outputFilename path to save decompressed data
     */
    public static void decompressFile(String inputFilename, String outputFilename) {
        try (Scanner scanner = new Scanner(new File(inputFilename));
             PrintWriter writer = new PrintWriter(new File(outputFilename))) {

            while (scanner.hasNext()) {
                String bit = scanner.next();
                int count = scanner.nextInt();

                for (int i = 0; i < count; i++) {
                    writer.print(bit + " ");
                }
            }

            System.out.println("Decompression completed successfully.");

        } catch (IOException e) {
            System.err.println("Error processing file: " + e.getMessage());
        } catch (NoSuchElementException e) {
            System.err.println("Corrupt compressed file: " + e.getMessage());
        }
    }
}


