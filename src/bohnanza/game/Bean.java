package bohnanza.game;

public abstract class Bean extends Card<Type> {

    private final Beanometer beanometer;

    public static final String SPACE = " ";

    protected Bean(Type type, Beanometer beanometer) {
        super(type);
        this.beanometer = beanometer;
    }

    public Beanometer getBeanometer() {
        return beanometer;
    }

    @Override
    public int hashCode() {
        return getType().ordinal();
    }

    @Override
    public String toString() {
        return super.toString() + SPACE + beanometer.toString();
    }

}
