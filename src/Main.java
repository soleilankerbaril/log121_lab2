import Views.Environment;
import Views.MainWindow;

public class Main {
    public static void main(String[] args) {
        Environment environment = new Environment();
        MainWindow fenetre = new MainWindow();

        environment.addPropertyChangeListener(fenetre);
        environment.execute();
    }
}