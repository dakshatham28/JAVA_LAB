package see;

import cie.personal;

public class external extends personal {
    public int[] seeMarks = new int[5];

    public external(String usn, String name, int sem, int[] see) {
        super(usn, name, sem);

        for (int i = 0; i < 5; i++)
            seeMarks[i] = see[i] / 2;  
            // SEE is out of 100, but internal is out of 50 → convert to 50
    }
}