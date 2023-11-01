public class rubikMain {
    public static void main(String[] args) {
        rubikModel rubikmodel = new rubikModel();
        rubikGUI rubikgui = new rubikGUI(rubikmodel);
        rubikController controller = new rubikController(rubikmodel, rubikgui);
    }

}
