import org.json.simple.JSONObject;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class WeatherAppGui extends JFrame {
    private JSONObject weatherData;
    private JLabel weatherConditionImage;

    public WeatherAppGui() {
        super("Weather App");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(450, 650);
        setLocationRelativeTo(null);
        setResizable(false);


        setContentPane(new BackgroundPanel("src/assets/after.png"));


        setLayout(null);

        addGuiComponents();
    }

    private void addGuiComponents() {
        JTextField searchTextField = new JTextField();
        searchTextField.setBounds(15, 15, 351, 45);
        searchTextField.setFont(new Font("Dialog", Font.PLAIN, 24));
        add(searchTextField);

        weatherConditionImage = new JLabel(loadImage("src/assets/cloudy.png"));
        weatherConditionImage.setBounds(0, 125, 450, 217);
        add(weatherConditionImage);

        JLabel temperatureText = new JLabel("10 C");
        temperatureText.setBounds(0, 350, 450, 54);
        temperatureText.setFont(new Font("Dialog", Font.BOLD, 48));
        temperatureText.setHorizontalAlignment(SwingConstants.CENTER);
        add(temperatureText);

        JLabel weatherConditionDesc = new JLabel("Cloudy");
        weatherConditionDesc.setBounds(0, 405, 450, 36);
        weatherConditionDesc.setFont(new Font("Dialog", Font.PLAIN, 32));
        weatherConditionDesc.setHorizontalAlignment(SwingConstants.CENTER);
        add(weatherConditionDesc);

        JLabel humidityImage = new JLabel(loadImage("src/assets/humidity.png"));
        humidityImage.setBounds(15, 500, 74, 66);
        add(humidityImage);

        JLabel humidityText = new JLabel("<html><b>Humidity</b> 100%</html>");
        humidityText.setBounds(90, 500, 85, 55);
        humidityText.setFont(new Font("Dialog", Font.PLAIN, 16));
        add(humidityText);

        JLabel windspeedImage = new JLabel(loadImage("src/assets/windspeed.png"));
        windspeedImage.setBounds(220, 500, 74, 66);
        add(windspeedImage);

        JLabel windspeedText = new JLabel("<html><b>Windspeed</b> 15km/h</html>");
        windspeedText.setBounds(310, 500, 85, 55);
        windspeedText.setFont(new Font("Dialog", Font.PLAIN, 16));
        add(windspeedText);

        JButton searchButton = new JButton(loadImage("src/assets/search.png"));
        searchButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        searchButton.setBounds(375, 13, 47, 45);
        searchButton.addActionListener(e -> {
            String location = searchTextField.getText();
            JSONObject weatherData = WeatherApp.getWeatherData(location);

            if (weatherData != null) {
                temperatureText.setText(weatherData.get("temperature") + "°C");
                weatherConditionDesc.setText((String) weatherData.get("weather_condition"));
                humidityText.setText("<html><b>Humidity</b> " + weatherData.get("humidity") + "%</html>");
                windspeedText.setText("<html><b>Windspeed</b> " + weatherData.get("windspeed") + " m/s</html>");


                updateWeatherImage((String) weatherData.get("weather_condition"));
            } else {
                JOptionPane.showMessageDialog(this, "Weather data could not be fetched.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        add(searchButton);
    }

    private void updateWeatherImage(String weatherCondition) {
        String imagePath = "src/assets/cloudy.png";


        switch (weatherCondition.toLowerCase()) {
            case "clear":
                imagePath = "src/assets/clear.png";
                break;
            case "cloudy":
                imagePath = "src/assets/cloudy.png";
                break;
            case "rain":
                imagePath = "src/assets/rain.png";
                break;
            case "snow":
                imagePath = "src/assets/snow.png";
                break;
            default:
                imagePath = "src/assets/unknown.png";
                break;
        }

        weatherConditionImage.setIcon(loadImage(imagePath));
    }

    private ImageIcon loadImage(String imagePath) {
        try {
            BufferedImage img = ImageIO.read(new File(imagePath));
            return new ImageIcon(img);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static class BackgroundPanel extends JPanel {
        private final Image backgroundImage;

        public BackgroundPanel(String imagePath) {
            this.backgroundImage = new ImageIcon(imagePath).getImage();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
