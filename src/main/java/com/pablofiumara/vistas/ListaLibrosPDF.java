package com.pablofiumara.vistas;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfAction;
import com.lowagie.text.pdf.PdfDestination;
import com.lowagie.text.pdf.PdfWriter;
import com.pablofiumara.modelo.Libro;


public class ListaLibrosPDF extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model,
			Document document, PdfWriter writer, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		@SuppressWarnings("unchecked")
		List<Libro> listaDeLibros = (List<Libro>) model.get("listaLibros");

		Table table = new Table(2);
		table.addCell("ID del libro");
		table.addCell("Título del libro");
		
		 for (Libro unLibro : listaDeLibros) {
	            table.addCell(String.valueOf(unLibro.getId())  );
	            table.addCell(unLibro.getTitulo());
	        }

		

		document.add(table);

		
		writer.setOpenAction(PdfAction.gotoLocalPage(1, new PdfDestination(
				PdfDestination.XYZ, 0, 10000, 1), writer));
	}
}