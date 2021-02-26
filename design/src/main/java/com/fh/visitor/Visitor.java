package com.fh.visitor;

public interface Visitor {

    void visit(PdfFile file);

    void visit(WordFile file);

    void visit(PPTFile file);
}
