/**
 * Copyright (C) 2011-2015 52°North Initiative for Geospatial Open Source
 * Software GmbH
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 as published
 * by the Free Software Foundation.
 *
 * If the program is linked with libraries which are licensed under one of
 * the following licenses, the combination of the program with the linked
 * library is not considered a "derivative work" of the program:
 *
 *     - Apache License, version 2.0
 *     - Apache Software License, version 1.0
 *     - GNU Lesser General Public License, version 3
 *     - Mozilla Public License, versions 1.0, 1.1 and 2.0
 *     - Common Development and Distribution License (CDDL), version 1.0
 *
 * Therefore the distribution of the program linked with libraries licensed
 * under the aforementioned licenses, is permitted by the copyright holders
 * if the distribution is compliant with both the GNU General Public
 * License version 2 and the aforementioned licenses.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General
 * Public License for more details.
 */
package org.n52.sos.importer.model.dateAndTime;

import org.n52.sos.importer.model.Combination;
import org.n52.sos.importer.model.Component;
import org.n52.sos.importer.view.MissingComponentPanel;
import org.n52.sos.importer.view.dateAndTime.MissingDatePanel;

/**
 * aggregates year, month and day
 * @author Raimund
 */
public class Date extends Component {

	private Year year;
	
	private Month month;
	
	private Day day;

	public void setYear(Year year) {
		this.year = year;
	}

	public Year getYear() {		
		return year;
	}

	public void setMonth(Month month) {
		this.month = month;
	}

	public Month getMonth() {
		return month;
	}

	public void setDay(Day day) {
		this.day = day;
	}

	public Day getDay() {
		return day;
	}

	@Override
	public MissingComponentPanel getMissingComponentPanel(Combination c) {
		return new MissingDatePanel((DateAndTime)c);
	}
}
