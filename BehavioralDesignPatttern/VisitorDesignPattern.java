interface Patient {
    void accept(Visitor visitor);
}

// Child Patient
class ChildPatient implements Patient {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

// AdultPatient
class AdultPatient implements Patient {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

// SeniorPatient
class SeniorPatient implements Patient {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

interface Visitor {
    void visit(ChildPatient childPatient);

    void visit(AdultPatient adultPatient);

    void visit(SeniorPatient seniorPatient);
}

class DiagnosisVisitor implements Visitor {
    @Override
    public void visit(ChildPatient childPatient) {
        System.out.println(
                "Diagnosing a child patient: Check-up and pediatric care.");
    }

    @Override
    public void visit(AdultPatient adultPatient) {
        System.out.println(
                "Diagnosing an adult patient: Routine exams and lifestyle advice.");
    }

    @Override
    public void visit(SeniorPatient seniorPatient) {
        System.out.println(
                "Diagnosing a senior patient: Comprehensive geriatric evaluation.");
    }
}

class BillingVisitor implements Visitor {
    @Override
    public void visit(ChildPatient childPatient) {
        System.out.println("Calculating billing for a child patient.");
    }

    @Override
    public void visit(AdultPatient adultPatient) {
        System.out.println("Calculating billing for an adult patient.");
    }

    @Override
    public void visit(SeniorPatient seniorPatient) {
        System.out.println("Calculating billing for a senior patient.");
    }
}

public class VisitorDesignPattern {
    public static void main(String[] args) {
        Patient[] patients = { new ChildPatient(), new AdultPatient(), new SeniorPatient() };
        // Create visitors for different operations
        Visitor diagnosisVisitor = new DiagnosisVisitor();
        Visitor billingVisitor = new BillingVisitor();
        // Each patient accepts the visitors to perform the operations
        for (Patient patient : patients) {
            patient.accept(diagnosisVisitor);
            patient.accept(billingVisitor);
        }
    }
}