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
package org.n52.sos.importer.test;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.List;

import org.n52.sos.importer.model.CsvData;
import org.n52.sos.importer.model.measuredValue.MeasuredValue;
import org.n52.sos.importer.model.measuredValue.NumericValue;
import org.n52.sos.importer.model.position.EPSGCode;
import org.n52.sos.importer.model.position.Height;
import org.n52.sos.importer.model.position.Latitude;
import org.n52.sos.importer.model.position.Longitude;
import org.n52.sos.importer.model.position.Position;
import org.n52.sos.importer.model.resources.FeatureOfInterest;
import org.n52.sos.importer.model.resources.ObservedProperty;
import org.n52.sos.importer.model.table.Column;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author e.h.juerrens@52north.org
 * This class holds shared test data for the other test classes.
 */
public class TestData {

	private static final Logger logger = LoggerFactory.getLogger(TestData.class);

	private static final CsvData convert(final String[][] data) {
		final CsvData csv = new CsvData();
		final List<String[]> lines = new LinkedList<>();
		for (final String[] line : data) {
			lines.add(line);
		}
		csv.setLines(lines);
		return csv;
	}

	public static final CsvData EXAMPLE_TABLE_MINI = convert(new String[][]{
			{"01/06/2010", "11:45", "12,12", "23,123"},
			{"01/06/2010", "23:45", "323,123", "432,123"}
	});

	public static final CsvData EXAMPLE_TABLE_MINI_ONLY_STRINGS = convert(new String[][]{
		{"bla", "bla2"},
		{"bla3", "bla4"},
		{"bla5", "bla6"}
	});

	public static final CsvData EXAMPLE_TABLE_MINI_MISSING_OBSERVED_PROPERTY = convert(new String[][] {
			{"Datum", "Station", "Komp", "Wert/myg/m3"},
			{"01.01.03", "Klinthal", "PM10", "-999"},
			{"02.01.03", "Klinthal", "PM10", "-999"},
			{"03.01.03", "Zwickau", "PM10", "-999"},
			{"04.01.03", "Zwickau", "PM12", "-999"}
	});

	/**
	 * Example GLDAS data set with 7 columns:<br />
	 * <code>"Id"; "X_1"; "Y_1"; "Temp";          "_Date"; "Hour"; "Minute"</code><br />
	 * <code>0,00; 11,87; 50,12;   0,46;1.1.2006 00:00:00;   0,00; 0,00</code>
	 */
	public static final CsvData EXMAPLE_TABLE_GLDAS = convert(new String[][]{
		{"Id",	 "X_1",	  "Y_1",   "Temp", "_Date",				"Hour",	"Minute"},
		{"0,00", "11,87", "50,12", "0,46", "1.1.2006 00:00:00", "0,00", "0,00"},
		{"0,00", "12,12", "50,12", "0,28", "1.1.2006 00:00:00", "0,00", "0,00"},
		{"0,00", "12,37", "50,12", "0,87", "1.1.2006 00:00:00", "0,00", "0,00"},
		{"0,00", "12,62", "50,12", "1,48", "1.1.2006 00:00:00", "0,00", "0,00"},
		{"0,00", "12,87", "50,12", "0,88", "1.1.2006 00:00:00", "0,00", "0,00"},
		{"0,00", "13,12", "50,12", "0,80", "1.1.2006 00:00:00", "0,00", "0,00"},
		{"0,00", "13,37", "50,12", "0,44", "1.1.2006 00:00:00", "0,00", "0,00"},
		{"0,00", "13,62", "50,12", "0,76", "1.1.2006 00:00:00", "0,00", "0,00"},
		{"0,00", "13,87", "50,12", "0,80", "1.1.2006 00:00:00", "0,00", "0,00"},
		{"0,00", "14,12", "50,12", "0,76", "1.1.2006 00:00:00", "0,00", "0,00"},
		{"0,00", "14,37", "50,12", "0,77", "1.1.2006 00:00:00", "0,00", "0,00"},
		{"0,00", "14,62", "50,12", "0,93", "1.1.2006 00:00:00", "0,00", "0,00"},
		{"0,00", "14,87", "50,12", "1,12", "1.1.2006 00:00:00", "0,00", "0,00"},
		{"0,00", "15,12", "50,12", "1,20", "1.1.2006 00:00:00", "0,00", "0,00"},
		{"0,00", "11,87", "50,37", "0,37", "1.1.2006 00:00:00", "0,00", "0,00"},
		{"0,00", "12,12", "50,37", "0,86", "1.1.2006 00:00:00", "0,00", "0,00"},
		{"0,00", "12,37", "50,37", "1,40", "1.1.2006 00:00:00", "0,00", "0,00"},
		{"0,00", "12,62", "50,37", "0,78", "1.1.2006 00:00:00", "0,00", "0,00"},
		{"0,00", "12,87", "50,37", "0,11", "1.1.2006 00:00:00", "0,00", "0,00"},
		{"0,00", "13,12", "50,37", "0,18", "1.1.2006 00:00:00", "0,00", "0,00"},
		{"0,00", "13,37", "50,37", "0,64", "1.1.2006 00:00:00", "0,00", "0,00"},
		{"0,00", "13,62", "50,37", "1,58", "1.1.2006 00:00:00", "0,00", "0,00"},
		{"0,00", "13,87", "50,37", "1,95", "1.1.2006 00:00:00", "0,00", "0,00"},
		{"0,00", "14,12", "50,37", "1,57", "1.1.2006 00:00:00", "0,00", "0,00"},
		{"0,00", "14,37", "50,37", "1,64", "1.1.2006 00:00:00", "0,00", "0,00"},
		{"0,00", "14,62", "50,37", "1,36", "1.1.2006 00:00:00", "0,00", "0,00"},
		{"0,00", "14,87", "50,37", "0,90", "1.1.2006 00:00:00", "0,00", "0,00"},
		{"0,00", "15,12", "50,37", "1,07", "1.1.2006 00:00:00", "0,00", "0,00"},
		{"0,00", "11,87", "50,62", "1,28", "1.1.2006 00:00:00", "0,00", "0,00"},
	});

	/**
	 * Example data set with 8 columns<br />
	 * <code>Timestamp Sensor Phenomenon Feature UOM Value Feature UOM Value</code><br />
	 * <code>2012-04-23 11:52:23 Thermometer Temperature Münster degC 14.5 Berlin degC 14.5</code>
	 */
	public static final CsvData EXAMPLE_TABLE = convert(new String[][]{
				//         0				1			2				3		4		5		6			7		8
				{"Timestamp",			"Sensor",	   "Phenomenon",  "Feature", "UOM",  "Value","Feature","UOM",  "Value"},
				{"2012-04-23 11:52:23", "Thermometer", "Temperature", "Münster", "degC", "14.5", "Berlin", "degC", "14.5"},
				{"2012-04-23 11:52:33", "Thermometer", "Temperature", "Münster", "degC", "15.5", "Berlin", "degC", "15.5"},
				{"2012-04-23 11:52:43", "Thermometer", "Temperature", "Münster", "degC", "13.5", "Berlin", "degC", "13.5"},
				{"2012-04-23 11:52:53", "Thermometer", "Temperature", "Münster", "degC", "12.5", "Berlin", "degC", "12.5"},
				{"2012-04-23 11:53:03", "Thermometer", "Temperature", "Münster", "degC", "12.7", "Berlin", "degC", "12.7"},
				{"2012-04-23 11:53:13", "Thermometer", "Temperature", "Münster", "degC", "12.8", "Berlin", "degC", "12.8"},
				{"2012-04-23 11:53:23", "Thermometer", "Temperature", "Münster", "degC", "12.1", "Berlin", "degC", "12.1"},
				{"2012-04-23 11:53:33", "Thermometer", "Temperature", "Münster", "degC", "12.2", "Berlin", "degC", "12.4"},
				{"2012-04-23 11:53:43", "Thermometer", "Temperature", "Münster", "degC", "12.3", "Berlin", "degC", "12.5"},
				{"2012-04-23 11:53:53", "Thermometer", "Temperature", "Münster", "degC", "12.4", "Berlin", "degC", "12.6"},
				{"2012-04-23 11:54:13", "Thermometer", "Temperature", "Münster", "degC", "12.5", "Berlin", "degC", "12.7"},
				});

	/**
	 * Example data set with many columns<br />
	 * <code>Timestamp Sensor Phenomenon Feature UOM Value Feature UOM Value ...</code><br />
	 * <code>2012-04-23 11:52:23 Thermometer Temperature Münster degC 14.5 Berlin degC 14.5 ...</code>
	 */
	public static final CsvData EXAMPLE_TABLE_MANY_MANY_COLUMNS = convert(new String[][]{
				//         0				1			2				3		4		5		6			7		8
				{"Timestamp",			"Sensor",	   "Phenomenon",  "Feature", "UOM",  "Value","Feature","UOM",  "Value", "Sensor", "Phenomenon",  "Feature", "UOM",  "Value","Feature","UOM",  "Value", "Sensor", "Phenomenon",  "Feature", "UOM",  "Value","Feature","UOM",  "Value", "Sensor", "Phenomenon",  "Feature", "UOM",  "Value","Feature","UOM",  "Value", "Sensor", "Phenomenon",  "Feature", "UOM",  "Value","Feature","UOM",  "Value", "Sensor", "Phenomenon",  "Feature", "UOM",  "Value","Feature","UOM",  "Value", "Sensor", "Phenomenon",  "Feature", "UOM",  "Value","Feature","UOM",  "Value", "Sensor", "Phenomenon",  "Feature", "UOM",  "Value","Feature","UOM",  "Value", "Sensor", "Phenomenon",  "Feature", "UOM",  "Value","Feature","UOM",  "Value", "Sensor", "Phenomenon",  "Feature", "UOM",  "Value","Feature","UOM",  "Value", "Sensor", "Phenomenon",  "Feature", "UOM",  "Value","Feature","UOM",  "Value"},
				{"2012-04-23 11:52:23", "Thermometer", "Temperature", "Münster", "degC", "14.5", "Berlin", "degC", "14.5", "Thermometer", "Temperature", "Münster", "degC", "14.5", "Berlin", "degC", "14.5", "Thermometer", "Temperature", "Münster", "degC", "14.5", "Berlin", "degC", "14.5", "Thermometer", "Temperature", "Münster", "degC", "14.5", "Berlin", "degC", "14.5", "Thermometer", "Temperature", "Münster", "degC", "14.5", "Berlin", "degC", "14.5", "Thermometer", "Temperature", "Münster", "degC", "14.5", "Berlin", "degC", "14.5", "Thermometer", "Temperature", "Münster", "degC", "14.5", "Berlin", "degC", "14.5", "Thermometer", "Temperature", "Münster", "degC", "14.5", "Berlin", "degC", "14.5", "Thermometer", "Temperature", "Münster", "degC", "14.5", "Berlin", "degC", "14.5", "Thermometer", "Temperature", "Münster", "degC", "14.5", "Berlin", "degC", "14.5", "Thermometer", "Temperature", "Münster", "degC", "14.5", "Berlin", "degC", "14.5"},
				{"2012-04-23 11:52:33", "Thermometer", "Temperature", "Münster", "degC", "15.5", "Berlin", "degC", "15.5", "Thermometer", "Temperature", "Münster", "degC", "15.5", "Berlin", "degC", "15.5", "Thermometer", "Temperature", "Münster", "degC", "15.5", "Berlin", "degC", "15.5", "Thermometer", "Temperature", "Münster", "degC", "15.5", "Berlin", "degC", "15.5", "Thermometer", "Temperature", "Münster", "degC", "15.5", "Berlin", "degC", "15.5", "Thermometer", "Temperature", "Münster", "degC", "15.5", "Berlin", "degC", "15.5", "Thermometer", "Temperature", "Münster", "degC", "15.5", "Berlin", "degC", "15.5", "Thermometer", "Temperature", "Münster", "degC", "15.5", "Berlin", "degC", "15.5", "Thermometer", "Temperature", "Münster", "degC", "15.5", "Berlin", "degC", "15.5", "Thermometer", "Temperature", "Münster", "degC", "15.5", "Berlin", "degC", "15.5", "Thermometer", "Temperature", "Münster", "degC", "15.5", "Berlin", "degC", "15.5"},
				{"2012-04-23 11:52:43", "Thermometer", "Temperature", "Münster", "degC", "13.5", "Berlin", "degC", "13.5", "Thermometer", "Temperature", "Münster", "degC", "13.5", "Berlin", "degC", "13.5", "Thermometer", "Temperature", "Münster", "degC", "13.5", "Berlin", "degC", "13.5", "Thermometer", "Temperature", "Münster", "degC", "13.5", "Berlin", "degC", "13.5", "Thermometer", "Temperature", "Münster", "degC", "13.5", "Berlin", "degC", "13.5", "Thermometer", "Temperature", "Münster", "degC", "13.5", "Berlin", "degC", "13.5", "Thermometer", "Temperature", "Münster", "degC", "13.5", "Berlin", "degC", "13.5", "Thermometer", "Temperature", "Münster", "degC", "13.5", "Berlin", "degC", "13.5", "Thermometer", "Temperature", "Münster", "degC", "13.5", "Berlin", "degC", "13.5", "Thermometer", "Temperature", "Münster", "degC", "13.5", "Berlin", "degC", "13.5", "Thermometer", "Temperature", "Münster", "degC", "13.5", "Berlin", "degC", "13.5"},
				{"2012-04-23 11:52:53", "Thermometer", "Temperature", "Münster", "degC", "12.5", "Berlin", "degC", "12.5", "Thermometer", "Temperature", "Münster", "degC", "12.5", "Berlin", "degC", "12.5", "Thermometer", "Temperature", "Münster", "degC", "12.5", "Berlin", "degC", "12.5", "Thermometer", "Temperature", "Münster", "degC", "12.5", "Berlin", "degC", "12.5", "Thermometer", "Temperature", "Münster", "degC", "12.5", "Berlin", "degC", "12.5", "Thermometer", "Temperature", "Münster", "degC", "12.5", "Berlin", "degC", "12.5", "Thermometer", "Temperature", "Münster", "degC", "12.5", "Berlin", "degC", "12.5", "Thermometer", "Temperature", "Münster", "degC", "12.5", "Berlin", "degC", "12.5", "Thermometer", "Temperature", "Münster", "degC", "12.5", "Berlin", "degC", "12.5", "Thermometer", "Temperature", "Münster", "degC", "12.5", "Berlin", "degC", "12.5", "Thermometer", "Temperature", "Münster", "degC", "12.5", "Berlin", "degC", "12.5"},
				{"2012-04-23 11:53:03", "Thermometer", "Temperature", "Münster", "degC", "12.7", "Berlin", "degC", "12.7", "Thermometer", "Temperature", "Münster", "degC", "12.7", "Berlin", "degC", "12.7", "Thermometer", "Temperature", "Münster", "degC", "12.7", "Berlin", "degC", "12.7", "Thermometer", "Temperature", "Münster", "degC", "12.7", "Berlin", "degC", "12.7", "Thermometer", "Temperature", "Münster", "degC", "12.7", "Berlin", "degC", "12.7", "Thermometer", "Temperature", "Münster", "degC", "12.7", "Berlin", "degC", "12.7", "Thermometer", "Temperature", "Münster", "degC", "12.7", "Berlin", "degC", "12.7", "Thermometer", "Temperature", "Münster", "degC", "12.7", "Berlin", "degC", "12.7", "Thermometer", "Temperature", "Münster", "degC", "12.7", "Berlin", "degC", "12.7", "Thermometer", "Temperature", "Münster", "degC", "12.7", "Berlin", "degC", "12.7", "Thermometer", "Temperature", "Münster", "degC", "12.7", "Berlin", "degC", "12.7"},
				{"2012-04-23 11:53:13", "Thermometer", "Temperature", "Münster", "degC", "12.8", "Berlin", "degC", "12.8", "Thermometer", "Temperature", "Münster", "degC", "12.8", "Berlin", "degC", "12.8", "Thermometer", "Temperature", "Münster", "degC", "12.8", "Berlin", "degC", "12.8", "Thermometer", "Temperature", "Münster", "degC", "12.8", "Berlin", "degC", "12.8", "Thermometer", "Temperature", "Münster", "degC", "12.8", "Berlin", "degC", "12.8", "Thermometer", "Temperature", "Münster", "degC", "12.8", "Berlin", "degC", "12.8", "Thermometer", "Temperature", "Münster", "degC", "12.8", "Berlin", "degC", "12.8", "Thermometer", "Temperature", "Münster", "degC", "12.8", "Berlin", "degC", "12.8", "Thermometer", "Temperature", "Münster", "degC", "12.8", "Berlin", "degC", "12.8", "Thermometer", "Temperature", "Münster", "degC", "12.8", "Berlin", "degC", "12.8", "Thermometer", "Temperature", "Münster", "degC", "12.8", "Berlin", "degC", "12.8"},
				});

	/**
	 * Example data set with 9 columns<br />
	 * <code>Timestamp Sensor Phenomenon Feature UOM Value Timestamp Feature UOM Value</code><br />
	 * <code>2012-04-23 11:52:23 Thermometer Temperature Münster degC 14.5 2012-04-23 10:52:23 London degC 14.5</code>
	 */
	public static final CsvData EXAMPLE_TABLE_MULTIPLE_DATE_TIME = convert(new String[][]{
		//         0				1			2				3		4		5		6						7			8		9
		{"Timestamp",			"Sensor",	   "Phenomenon",  "Feature", "UOM",  "Value", "Timestamp", 			"Feature","UOM",  "Value"},
		{"2012-04-23 11:52:23", "Thermometer", "Temperature", "Münster", "degC", "14.5", "2012-04-23 10:52:23", "London", "degC", "14.5"},
		{"2012-04-23 11:52:33", "Thermometer", "Temperature", "Münster", "degC", "15.5", "2012-04-23 10:52:33", "London", "degC", "15.5"},
		{"2012-04-23 11:52:43", "Thermometer", "Temperature", "Münster", "degC", "13.5", "2012-04-23 10:52:43", "London", "degC", "13.5"},
		{"2012-04-23 11:52:53", "Thermometer", "Temperature", "Münster", "degC", "12.5", "2012-04-23 10:52:53", "London", "degC", "12.5"},
		{"2012-04-23 11:53:03", "Thermometer", "Temperature", "Münster", "degC", "12.7", "2012-04-23 10:53:03", "London", "degC", "12.7"},
		{"2012-04-23 11:53:13", "Thermometer", "Temperature", "Münster", "degC", "12.8", "2012-04-23 10:53:13", "London", "degC", "12.8"},
		{"2012-04-23 11:53:23", "Thermometer", "Temperature", "Münster", "degC", "12.1", "2012-04-23 10:53:23", "London", "degC", "12.1"},
		{"2012-04-23 11:53:33", "Thermometer", "Temperature", "Münster", "degC", "12.2", "2012-04-23 10:53:33", "London", "degC", "12.4"},
		{"2012-04-23 11:53:43", "Thermometer", "Temperature", "Münster", "degC", "12.3", "2012-04-23 10:53:43", "London", "degC", "12.5"},
		{"2012-04-23 11:53:53", "Thermometer", "Temperature", "Münster", "degC", "12.4", "2012-04-23 10:53:53", "London", "degC", "12.6"},
		{"2012-04-23 11:54:13", "Thermometer", "Temperature", "Münster", "degC", "12.5", "2012-04-23 10:54:13", "London", "degC", "12.7"},
		});

	/**
	 * <code>"Timestamp","Sensor","Phenomenon","Feature","Value"</code><br />
	 * <code>"2012-04-23 11:52:23", "Thermometer", "Temperature", "Münster", "14.5"</code>
	 */
	public static final CsvData EXAMPLE_TABLE_NO_UOM =  convert(new String[][]{
		//         0				1			2				3			4
		{"Timestamp",			"Sensor",	   "Phenomenon",  "Feature", "Value"},
		{"2012-04-23 11:52:23", "Thermometer", "Temperature", "Münster", "14.5"},
		{"2012-04-23 11:52:33", "Thermometer", "Temperature", "Münster", "15.5"},
		{"2012-04-23 11:52:43", "Thermometer", "Temperature", "Münster", "13.5"},
		{"2012-04-23 11:52:53", "Thermometer", "Temperature", "Münster", "12.5"},
		{"2012-04-23 11:53:03", "Thermometer", "Temperature", "Münster", "12.7"},
		{"2012-04-23 11:53:13", "Thermometer", "Temperature", "Münster", "12.8"},
		{"2012-04-23 11:53:23", "Thermometer", "Temperature", "Münster", "12.1"},
		{"2012-04-23 11:53:33", "Thermometer", "Temperature", "Münster", "12.2"},
		{"2012-04-23 11:53:43", "Thermometer", "Temperature", "Münster", "12.3"},
		{"2012-04-23 11:53:53", "Thermometer", "Temperature", "Münster", "12.4"},
		{"2012-04-23 11:54:13", "Thermometer", "Temperature", "Münster", "12.5"},
		});

	/**
	 * Example data set without feature of interest
	 */
	public static final CsvData EXAMPLE_TABLE_NO_FOI = convert(new String[][]{
				//         0				1			2				3		4
				{"Timestamp",			"Sensor",	   "Phenomenon",  "UOM",  "Value"},
				{"2012-04-23 11:52:23", "Thermometer", "Temperature", "degC", "14.5"},
				{"2012-04-23 11:52:33", "Thermometer", "Temperature", "degC", "15.5"},
				{"2012-04-23 11:52:43", "Thermometer", "Temperature", "degC", "13.5"},
				{"2012-04-23 11:52:53", "Thermometer", "Temperature", "degC", "12.5"},
				{"2012-04-23 11:53:03", "Thermometer", "Temperature", "degC", "12.7"},
				{"2012-04-23 11:53:13", "Thermometer", "Temperature", "degC", "12.8"},
				{"2012-04-23 11:53:23", "Thermometer", "Temperature", "degC", "12.1"},
				{"2012-04-23 11:53:33", "Thermometer", "Temperature", "degC", "12.2"},
				{"2012-04-23 11:53:43", "Thermometer", "Temperature", "degC", "12.3"},
				{"2012-04-23 11:53:53", "Thermometer", "Temperature", "degC", "12.4"},
				{"2012-04-23 11:54:13", "Thermometer", "Temperature", "degC", "12.5"},
				});
	/**
	 * Example data set without feature of interest
	 */
	public static final CsvData EXAMPLE_TABLE_NO_FOI_BUT_POSITION = convert(new String[][]{
				//         0				1			2				3		4		5			6
				{"Timestamp",			"Sensor",	   "Phenomenon",  "UOM",  "Value",	 "LON",	  "LAT"},
				{"2012-04-23 11:52:23", "Thermometer", "Temperature", "degC", "14.5",  "11.87", "50.12"},
				{"2012-04-23 11:52:33", "Thermometer", "Temperature", "degC", "15.5",  "11.88", "50.12"},
				{"2012-04-23 11:52:43", "Thermometer", "Temperature", "degC", "13.5",  "11.89", "50.12"},
				{"2012-04-23 11:52:53", "Thermometer", "Temperature", "degC", "12.5",  "11.90", "50.12"},
				{"2012-04-23 11:53:03", "Thermometer", "Temperature", "degC", "12.7",  "11.91", "50.12"},
				{"2012-04-23 11:53:13", "Thermometer", "Temperature", "degC", "12.8",  "11.92", "50.12"},
				{"2012-04-23 11:53:23", "Thermometer", "Temperature", "degC", "12.1",  "11.93", "50.12"},
				{"2012-04-23 11:53:33", "Thermometer", "Temperature", "degC", "12.2",  "11.94", "50.12"},
				{"2012-04-23 11:53:43", "Thermometer", "Temperature", "degC", "12.3",  "11.95", "50.12"},
				{"2012-04-23 11:53:53", "Thermometer", "Temperature", "degC", "12.4",  "11.96", "50.12"},
				{"2012-04-23 11:54:13", "Thermometer", "Temperature", "degC", "12.5",  "11.97", "50.12"},
				});
	/**
	 * Example feature of interest with position: lat: 52, long: 7, alt: 42,
	 * epsg: 4979, table element: col 3, flwd 1</br>
	 * To change the related column call foi.setTableElement(new Column(newColumnId, firstlinewithData);
	 */
	public static final FeatureOfInterest EXAMPLE_FOI = TestData.exampleFoi();

	private static FeatureOfInterest exampleFoi() {
		if (logger.isTraceEnabled()) {
			logger.trace("exampleFoi()");
		}
		final FeatureOfInterest foi = new FeatureOfInterest();

		foi.setName("FOI_TEST_1");
		foi.setGenerated(false);
		foi.setPosition(new Position(
				new Latitude(52.0, "deg"),
				new Longitude(7.0, "deg"),
				new Height(42.0, "m"),
				new EPSGCode(4979)));
		try {
			foi.setURI(new URI("http://example.com/spatial/fois/test/1"));
		} catch (final URISyntaxException e) {
			logger.error("Exception thrown: " + e.getMessage(), e);
		}
		foi.setTableElement(new Column(3, 1));
		return foi;
	}

	/**
	 * Example observed property created from manual input. Related table element: col 3, flwd 1</br>
	 * To change the related column call <code>obsProp.setTableElement(new Column(newColumnId, firstlinewithData);</code>
	 */
	public static final ObservedProperty EXAMPLE_OBS_PROP = TestData.exampleObsProp();

	private static ObservedProperty exampleObsProp() {
		if (logger.isTraceEnabled()) {
			logger.trace("exampleObsProp()");
		}
		final ObservedProperty obsProp = new ObservedProperty();
		obsProp.setName("OBS_PROP_TEST_1");
		obsProp.setGenerated(false);
		try {
			obsProp.setURI(new URI("http://example.com/spatial/observedproperties/test/1"));
		} catch (final URISyntaxException e) {
			logger.error("Exception thrown: " + e.getMessage(), e);
		}
		obsProp.setTableElement(new Column(3, 1));
		return obsProp;
	}

	/**
	 * Example measure value of type numeric. Related table element is: col 1, flwd 1.<br />
	 * To change the related column call <code>mv.setTableElement(new Column(newColumnId, firstlinewithData);</code>
	 */
	public static final MeasuredValue EXAMPLE_MEASURED_VALUE_NUMERIC = TestData.exampleMVnumeric();


	private static MeasuredValue exampleMVnumeric() {
		if (logger.isTraceEnabled()) {
			logger.trace("exampleMVnumeric()");
		}
		final NumericValue nv = new NumericValue();
		nv.setTableElement(new Column(1, 1));
		return nv;
	}
}
