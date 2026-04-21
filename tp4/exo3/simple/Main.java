package tp4.exo3.simple;

public class Main {
    public static void main(String[] args) {
        Individual ind = new Individual("Ali", "IND001", "ali@lib.dz");
        Staff staff = new Staff("Sara", "STF001", "sara@lib.dz", "Archives", 5);
        SeniorStaff senior = new SeniorStaff("Karim", "SNR001", "karim@lib.dz", "Management", 12, "High");

        System.out.println(ind);
        System.out.println(staff);
        System.out.println(senior);

        staff.performStaffDuties();
        staff.assistUsers();
        senior.manageSection();

        System.out.println();

        Item item = new Item("Java Programming", "BK001", 2023);
        SpecialItem special = new SpecialItem("Ancient Manuscript", "SP001", 1850, "Historical", true);

        System.out.println(item);
        System.out.println(special);

        special.showReference();
        special.checkAccess();
    }
}
