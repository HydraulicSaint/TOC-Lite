import javax.swing.*;
import java.awt.*;
import java.io.OutputStream;
import java.io.PrintStream;

public class TOCGUI extends JFrame {
    private TOCApp app;
    private JTextArea outputArea;
    private JTextField inputField;

    public TOCGUI() {
        super("TOC-Lite UI");
        app = new TOCApp();
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        inputField = new JTextField();
        inputField.addActionListener(e -> {
            String cmd = inputField.getText();
            inputField.setText("");
            if ("exit".equalsIgnoreCase(cmd)) {
                System.exit(0);
            }
            app.executeCommand(cmd);
        });

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(inputField, BorderLayout.SOUTH);
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        redirectSystemStreams();
    }

    private void redirectSystemStreams() {
        PrintStream ps = new PrintStream(new OutputStream() {
            @Override
            public void write(int b) {
                outputArea.append(String.valueOf((char) b));
                outputArea.setCaretPosition(outputArea.getDocument().getLength());
            }
        }, true);
        System.setOut(ps);
        System.setErr(ps);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TOCGUI().setVisible(true);
        });
    }
}
