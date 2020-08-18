package com.javase.day0730.old;

public class Printer {
    private IInkBox iInkBox;

    private IPaper iPaper;

    public Printer(IInkBox iInkBox, IPaper iPaper) {
        this.iInkBox = iInkBox;
        this.iPaper = iPaper;
    }

    public Printer() {
    }

    public IInkBox getiInkBox() {
        return iInkBox;
    }

    public void setiInkBox(IInkBox iInkBox) {
        this.iInkBox = iInkBox;
    }

    public IPaper getiPaper() {
        return iPaper;
    }

    public void setiPaper(IPaper iPaper) {
        this.iPaper = iPaper;
    }

    public void print() {
        System.out.println("用" + iInkBox.getColor() + ", " + iPaper.getSize() + "打印");
    }

    public static void main(String[] args) {
        IPaper A4Paper = new A4Paper();
        IInkBox blackIInkBox = new BlackInkBox();
        Printer printer = new Printer();
        printer.setiInkBox(blackIInkBox);
        printer.setiPaper(A4Paper);
        printer.print();
        IPaper b5Paper = new B5Paper();
        IInkBox colorIInkBox = new ColorInkBox();
        printer.setiPaper(b5Paper);
        printer.setiInkBox(colorIInkBox);
        printer.print();
    }
}
