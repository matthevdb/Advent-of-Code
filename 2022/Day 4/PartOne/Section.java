public class Section {
    private int lowerBound;
    private int upperBound;

    public Section(int lowerBound, int upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    public int getLowerBound() {
        return lowerBound;
    }

    public int getUpperBound() {
        return upperBound;
    }

    public boolean contains(Section section) {
        if (this.lowerBound <= section.lowerBound && this.upperBound >= section.upperBound) {
            return true;
        }
        return false;
    }
}
