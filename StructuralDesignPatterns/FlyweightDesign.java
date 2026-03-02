import java.util.HashMap;
import java.util.Map;

class ParticleType {
    private final String color;
    private final String sprite;

    public ParticleType(String color, String sprite) {
        this.color = color;
        this.sprite = sprite;
    }

    public void render(float x, float y, float velocity) {
        System.out.println("Rendering " + color + " particle at (" + x + "," + y +
                ") with sprite " + sprite);
    }
}

class ParticleTypeFactory {
    private Map<String, ParticleType> particleTypes = new HashMap<>();

    public ParticleType getParticleType(String color, String sprite) {
        String key = color + "_" + sprite;
        return particleTypes.computeIfAbsent(key, k -> new ParticleType(color, sprite));
    }
}

class Particle {
    private ParticleType type;
    private float x;
    private float y;
    private float velocity;

    public Particle(ParticleType type, float x, float y, float velocity) {
        this.type = type;
        this.x = x;
        this.y = y;
        this.velocity = velocity;
    }

    public void update() {
        y += velocity;
        type.render(x, y, velocity);
    }
}

public class FlyweightDesign {
    public static void main(String[] args) {

    }
}