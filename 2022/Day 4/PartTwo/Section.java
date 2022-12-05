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

    public boolean containsSection(Section section) {
        if (this.lowerBound <= section.lowerBound && this.upperBound >= section.upperBound) {
            return true;
        }
        return false;
    }

    public boolean containsNumber(int number) {
        if (number >= lowerBound && number <= upperBound) {
            return true;
        }

        return false;
    }

    public boolean overlaps(Section section) {
        for (int i = this.lowerBound; i <= this.upperBound; i++) {
            if (section.containsNumber(i)) {
                return true;
            }
        }
        
        return false;
    }
}
