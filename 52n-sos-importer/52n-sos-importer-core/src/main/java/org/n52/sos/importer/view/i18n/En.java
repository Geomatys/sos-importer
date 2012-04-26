/**
 * Copyright (C) 2012
 * by 52North Initiative for Geospatial Open Source Software GmbH
 *
 * Contact: Andreas Wytzisk
 * 52 North Initiative for Geospatial Open Source Software GmbH
 * Martin-Luther-King-Weg 24
 * 48155 Muenster, Germany
 * info@52north.org
 *
 * This program is free software; you can redistribute and/or modify it under
 * the terms of the GNU General Public License version 2 as published by the
 * Free Software Foundation.
 *
 * This program is distributed WITHOUT ANY WARRANTY; even without the implied
 * WARRANTY OF MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program (see gnu-gpl v2.txt). If not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA or
 * visit the Free Software Foundation web page, http://www.fsf.org.
 */
package org.n52.sos.importer.view.i18n;


import java.io.File;
import java.util.Locale;

import org.n52.sos.importer.view.utils.Constants;

/**
 * @author e.h.juerrens@52north.org
 * This class contains all String used by the GUI in English
 */
public class En extends Lang{
	
	private final static Locale locale = Locale.ENGLISH;
	
	@Override
	public String altitude() {
		return "Altitude / Height";
	}
	
	@Override
	public String and() {
		return "and";
	}

	public String backButtonLabel() {
		return "Back";
	}

	@Override
	public String column() {
		return "column";
	}

	@Override
	public String date() {
		return "Date";
	}

	@Override
	public String day() {
		return "Day";
	}

	@Override
	public String epsgCode() {
		return "EPSG-Code";
	}

	@Override
	public String epsgCodeWarningDialogNaturalNumber() {
		return "The " + Lang.l().epsgCode() + " has to be a natural number.";
	}

	@Override
	public String epsgCodeWarningDialogOutOfRange() {
		return null;
	}

	@Override
	public String error() {
		return "Error";
	}

	public String errorDialogTitle() {
		return "Error";
	}

	@Override
	public String example() {
		return "Example";
	}

	public String exitDialogQuestion() { 
		return "Do you really want to exit?\n";
	}

	public String exitDialogTitle() { return "Exit"; }

	public String featureOfInterest() {
		return "Feature of Interest";
	}

	public String file() {
		return "file";
	}

	public String finishButtonLabel() {
		return "Finish";
	}

	@Override
	public String format() {
		return "Format";
	}
	
	@Override
	public Locale getLocale() {
		return En.locale;
	}

	@Override
	public String group() {
		return "Group";
	}

	@Override
	public String heightWarningDialogDecimalNumber() {
		return "The " + this.altitude() + " has to be a decimal number.";
	}

	@Override
	public String hours() {
		return "Hours";
	}

	public String infoDialogTitle() {
		return "Info";
	}

	@Override
	public String latitudeDialogDecimalValue() {
		return "The " + this.latitudeNorthing() + " can only be a decimal number so far.";
	}

	@Override
	public String latitudeNorthing() {
		return "Latitude / Northing";
	}

	@Override
	public String longitudeDialogDecimalValue() {
		return "The " + this.longitudeEasting() + " can only be a decimal number so far.";
	}

	@Override
	public String longitudeEasting() {
		return "Longitude / Easting";
	}

	public String measuredValue() {
		return "measured value";
	}

	@Override
	public String minutes() {
		return "Minutes";
	}

	@Override
	public String month() {
		return "Month";
	}

	public String nextButtonLabel() {
		return "Next";
	}

	public String numValuePanelDecimalSeparator() {
		return "Decimal separator";
	}

	public String numValuePanelThousandsSeparator() {
		return "Thousands separator";
	}

	public String observation() {
		return "Observation";
	}

	public String observedProperty() {
		return "Observed Property";
	}
	
	public String path() {
		return "path";
	}

	public String position() {
		return "Position";
	}

	@Override
	public String referenceSystem() {
		return "Reference System";
	}

	@Override
	public String row() {
		return "row";
	}

	@Override
	public String seconds() {
		return "Seconds";
	}

	public String sensor() {
		return "Sensor";
	}

	@Override
	public String sosURL() {
		return "SOS-URL (incl. endpoint, e.g. http://[...]/sos)";
	}

	public String spaceString() {
		return "Space";
	}

	public String step() { return "Step"; }

	public String step1BrowseButton() {
		return "Select data file";
	}

	public String step1Description() {
		return this.step() + " 1: Choose CSV file";
	}

	public String step1File() {
		return "CSV File";
	}


	public String step1SelectLanguage() {
		return "Please select the language";
	}

	public String step2ColumnSeparator() {
		return "Column separator";
	}

	public String step2CommentIndicator() {
		return "Comment indicator";
	}

	@Override
	public String step2DataPreviewLabel() {
		return "CSV-Data-Preview";
	}

	public String step2Description() {
		return this.step() + " 2: Import CSV file";
	}

	public String step2FirstLineWithData() {
		return "First Line with data";
	}

	public String step2ParseHeader() {
		return "Interpret Header";
	}

	public String step2TextQualifier() {
		return "Text qualifier";
	}

	public String step3aDescription() {
		return this.step() + " 3a: Choose Metadata for the selected column";
	}

	@Override
	public String step3aMeasureValueColMissingDialogMessage() {
		return "You have to specify at least one " + this.measuredValue() + " column!";
	}

	@Override
	public String step3aMeasureValueColMissingDialogTitle() {
		return this.measuredValue() + " column missing";
	}

	@Override
	public String step3aParseTest1Failed() {
		return "1 value not parseable";
	}

	@Override
	public String step3aParseTestAllOk() {
		return "All values parseable";
	}

	@Override
	public String step3aParseTestNFailed(int n) {
		return n + " values not parseable";
	}

	@Override
	public String step3aSelectedColTypeUndefinedMsg() {
		return "The type for this column is \"" + 
				this.step3ColTypeUndefined() + 
				"\".\nPlease select one.\nChoose \"" +
				this.step3ColTypeDoNotExport() + 
				"\" for skipping it.";
	}

	@Override
	public String step3aSelectedColTypeUndefinedTitle() {
		return "Column Type is \"" + 
				this.step3ColTypeUndefined() + 
				"\"";
	}
	
	public String step3bDescription() {
		return this.step() + " 3b: Choose metadata for rows";
	}

	public String step3ColTypeDateTime() {
		return "Date & Time";
	}

	public String step3ColTypeDoNotExport() {
		return "Do not export";
	}

	public String step3ColTypeMeasuredValue() {
		return "Measured Value";
	}

	public String step3ColTypeUndefined() {
		return "Undefined";
	}

	public String step3DateAndTimeCombination() {
		return "Combination";
	}

	public String step3DateAndTimeUnixTime() {
		return "UNIX time";
	}

	public String step3MeasuredValBoolean() {
		return "Boolean";
	}

	public String step3MeasuredValCount() {
		return "Count";
	}

	public String step3MeasuredValNumericValue() {
		return "Numeric Value";
	}

	public String step3MeasuredValText() {
		return "Text";
	}

	public String step3PositionCombination() {
		return this.step3DateAndTimeCombination();
	}

	public String step4aDescription() {
		return this.step() + " 4a: Solve Date & Time ambiguities";
	}

	public String step4aInfoDateAndTime() {
		return "Date and Time are already set for this " + this.measuredValue() + ".";
	}

	public String step4aInfoMeasuredValue() {
		return "This is not a " + this.measuredValue() + ".";
	}

	public String step4aModelDescription() {
		return "Select all " + this.measuredValue() + " " + Constants.STRING_REPLACER + "s " +
				"where the marked Date & Time group corresponds to.";
	}

	public String step4bDescription() {
		return this.step() + " 4b: Solve ambiguities";
	}

	public String step4bInfoNotMeasuredValue() {
		return this.step4aInfoMeasuredValue();
	}

	@Override
	protected String step4bInfoResourceAlreadySetText() {
		return " already set for this ";
	}

	@Override
	public String step4bModelDescription() {
		return "Please click the " + 
			Constants.STRING_REPLACER +
			" (not the title) containing " +
			"the measured values for the marked " + 
			Constants.STRING_REPLACER + 
			" " +
			Constants.STRING_REPLACER + 
			" that is marked. If several " + 
			Constants.STRING_REPLACER + 
			"s corespond to this " + 
			Constants.STRING_REPLACER + 
			" " +
			Constants.STRING_REPLACER + 
			", click all of them with pressed CTRL key.";
	}

	public String step5aDescription() {
		return this.step() + " 5a: Complete time data";
	}

	public String step5aModelDescription() {
		return "Complete missing information for the marked date and time.";
	}

	public String step5cDescription() {
		return this.step() + " 5c: Complete position data";
	}

	public String step5cModelDescription() {
		return "Complete missing information for the marked position.";
	}

	public String step6aDescription() {
		return this.step() + " 6a: Add missing dates and times";
	}

	@Override
	public String step6aModelDescription() {
		return "<html>What is the <u>Date & Time</u> for all measured values?</html>";
	}

	public String step6bDescription() {
		return this.step() + " 6b: Add missing metadata";
	}

	public String step6bModelDescription() {
		return "<html>What is the <u>" + 
				Constants.STRING_REPLACER + 
				"</u> for the marked " + this.measuredValue() + " " + 
				Constants.STRING_REPLACER + 
				"?</html>";
	}

	public String step6bSpecialDescription() {
		return this.step() + " 6b (Special): Add missing " + this.sensor() + "s";
	}

	public String step6bSpecialModelDescription() {
		return "What is the " + this.sensor().toLowerCase(En.locale) + " for";
	}

	public String step6cDescription() {
		return this.step() + " 6c: Add missing " + this.position().toLowerCase(En.locale) + "s";
	}

	public String step6cModelDescription() {
		return "What is the " + this.position().toLowerCase(En.locale) + " of";
	}

	@Override
	public String step7ConfigDirNotDirOrWriteable(String folder) {
		return "The selected config file folder \n\"" + 
				folder + 
				"\"\nis not accessible for the application.";
	}

	@Override
	public String step7ConfigFileButton() {
		return "Choose folder";
	}

	@Override
	public String step7ConfigFileDialogTitel() {
		return "Select Configuration file folder";
	}

	@Override
	public String step7ConfigFileLabel() {
		return "Configuration file folder and name";
	}

	public String step7Description() {
		return this.step() + " 7: Choose " + this.sos();
	}

	@Override
	public String step7DirectImport() {
		return "Directly import data during next step";
	}

	@Override
	public String step7SaveConfig() {
		return "Save configuration to XML file";
	}

	public String step7SOSconnectionFailed(String strURL,
			int responseCode) {
		return "Could not connect to " + this.sos() + ": "
        		+ strURL + 
        		". HTTP Response Code: " 
        		+ responseCode;
	}

	public String step7SOSConnectionFailedException(String strURL,
			String message) {
		return "Connection to " + this.sos() + " " + strURL + " failed. Reason: " + message;
	}

	@Override
	public String step8ConfigFileButton() {
		return "Open Configuration File";
	}

	public String step8Description() {
		return this.step() + " 8: Final Step - Summary of the Results";
	}

	@Override
	public String step8DirectImportLabel() {
		return "Register Sensors and Insert Observations into Sensor Observation Service";
	}

	public String step8ErrorLable(int i) {
		return "Errors: " + i;
	}

	public String step8InsertObservationLabel(int i) {
		return "Insert " + i + " Observations...";
	}

	public String step8LogFileButton() {
		return "Check log file";
	}

	public String step8RegisterSensorLabel(int i) {
		return "Register " + i + " " + this.sensor() + "(s)...";
	}

	@Override
	public String step8SaveModelFailed(File f, String exceptionText) {
		return "The configuration could not be saved to file\n\"" +
				f.getAbsolutePath() +
				"\".\nAn Exception occurred:\n" +
				exceptionText +
				"Please check the log file for more details.";
	}

	public String step8SuccessLabel(int i) {
		return "Successful: " + i;
	}

	@Override
	public String time() {
		return "Time";
	}

	@Override
	public String timeZone() {
		return "UTC offset";
	}

	@Override
	public String unit() {
		return "Unit";
	}

	public String unitOfMeasurement() {
		return "Unit of Measurement";
	}

	public String warningDialogTitle() {
		return "Warning";
	}

	@Override
	public String year() {
		return "Year";
	}

}