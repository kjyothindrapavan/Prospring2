package com.aspress.prospring2.ch04.context;

public class ErrorReporter {
	public void evaluate(double[] values) {
		if(values.length % 2 !=0) {
			throw new SourceDataInvalidException(
					"@Lcom.aspress.prospring2.ch04.context.sourcedatainvalid", values.length);
		}
		for(int i=0;i<values.length;i++) {
			double value = values[i];
			if(value < 0)
				throw new ArgumentDomainException(
						"@Lcom.aspress.prosping2.ch04.context.argumentdomain",value);
			Math.log(value);
		}
	}
}
