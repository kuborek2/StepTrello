package anstar.StepTrello.mapper;

@FunctionalInterface
public interface Converter<T, F> {
    T convert(F from);
}
