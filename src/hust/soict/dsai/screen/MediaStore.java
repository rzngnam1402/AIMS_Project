package hust.soict.dsai.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MediaStore extends JPanel {
    private Media media;
    private Cart cart;

    public MediaStore(Media media, Cart cart) {
        this.media = media;
        this.cart = cart;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel("" + media.getCost() + "$");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton addToCart = new JButton("Add to cart");
        addToCart.addActionListener(new MediaStore.addToCartListener(media));
        container.add(addToCart);

        if (media instanceof Playable) {
            JButton playButton = new JButton("Play");
            playButton.addActionListener(new playListener());
            container.add(playButton);
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    private class playListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JFrame f = new JFrame();
            for (Frame fr : Frame.getFrames()) {
                if (fr.getTitle().equals("Store")) {
                    f = (JFrame) fr;
                    break;
                }
            }
            media.play();
            JDialog d = new JDialog(f, media.getTitle() + " is now being played...", true);
            JButton b = new JButton("Exit");
            d.setLayout(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();
            b.addActionListener(e1 -> d.setVisible(false));
            d.add(new JLabel("Click here to escape"));
            c.insets = new Insets(0, 10, 0, 0);
            d.add(b, c);
            d.setSize(300, 100);
            d.setLocationRelativeTo(f);
            d.setVisible(true);
        }
    }

    private class addToCartListener implements ActionListener {
        private Media media;

        public addToCartListener(Media media) {
            this.media = media;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame f = new JFrame();
            for (Frame fr : Frame.getFrames()) {
                if (fr.getTitle().equals("Store")) {
                    f = (JFrame) fr;
                    break;
                }
            }

            cart.addMedia(media);
            JDialog d = new JDialog(f, "Add item to cart successful!", true);
            JButton b = new JButton("Cancel");
            d.setLayout(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();
            b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    d.setVisible(false);
                }
            });
            d.add(new JLabel("Click here to escape"));
            c.insets = new Insets(0, 10, 0, 0);
            d.add(b, c);
            d.setSize(300, 100);
            d.setLocationRelativeTo(f);
            d.setVisible(true);
        }
    }
}
