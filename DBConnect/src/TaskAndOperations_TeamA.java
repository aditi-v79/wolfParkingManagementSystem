import java.util.Date;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.sql.PreparedStatement;

//	main class
public class TaskAndOperations_TeamA {
	static final String jdbcURL = "jdbc:mariadb://classdb2.csc.ncsu.edu:3306/jpradee";
	private static Connection connection = null;
	private static Statement statement = null;
	private static ResultSet result = null;
	
// main function
public static void main(String[] args) {
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
//			connecting to database
			connectToDatabase();
			} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		initialize();
		close();

}

// main menu
private static void initialize() {
	try (Scanner sc = new Scanner(System.in)) {
		int operation;
		loop:
		while(true) {
			System.out.println("Please select any tasks and operation related to Wolf Parking Management System");
			System.out.println("1. Select(Display) Data");
			System.out.println("2. Insert Data");
			System.out.println("3. Update Data");
			System.out.println("4. Delete Data");
			System.out.println("5. Reports");
			System.out.println("6. Exit");
			System.out.print("Enter Choice: ");
			operation=sc.nextInt();
			
			switch(operation) {
			case 1: int select=0;
				while(select!=13) {
					System.out.println("1. Select Vehicles");
					System.out.println("2. Select Drivers");
					System.out.println("3. Select ParkingLots");
					System.out.println("4. Select Zones");
					System.out.println("5. Select SpaceTypes");
					System.out.println("6. Select Spaces");
					System.out.println("7. Select Permit Types");
					System.out.println("8. Select Permits");
					System.out.println("9. Select Citation Categories");
					System.out.println("10. Select Citations");
					System.out.println("11. Select Payments");
					System.out.println("12. Select Appeals");
					System.out.println("13. Back to Main Menu");
					System.out.print("Enter Choice: ");
					select=sc.nextInt();
					switch(select) {
					case 1: selectVehicle(connection);
					System.out.println("\nPress enter to continue.\n");
					sc.nextLine();
					sc.nextLine();
						break;
					case 2: selectDriver(connection);
					System.out.println("\nPress enter to continue.\n");
					sc.nextLine();
					sc.nextLine();
						break;
					case 3: selectParkingLot(connection);
					System.out.println("\nPress enter to continue.\n");
					sc.nextLine();
					sc.nextLine();
						break;
					case 4: selectZone(connection);
					System.out.println("\nPress enter to continue.\n");
					sc.nextLine();
					sc.nextLine();
						break;
					case 5: selectSpaceType(connection);
					System.out.println("\nPress enter to continue.\n");
					sc.nextLine();
					sc.nextLine();
						break;
					case 6: selectSpace(connection);
					System.out.println("\nPress enter to continue.\n");
					sc.nextLine();
					sc.nextLine();
						break;
					case 7: selectPermitType(connection);
					System.out.println("\nPress enter to continue.\n");
					sc.nextLine();
					sc.nextLine();
						break;
					case 8: selectPermit(connection);
					System.out.println("\nPress enter to continue.\n");
					sc.nextLine();
					sc.nextLine();
						break;
					case 9: selectCitationCategory(connection);
					System.out.println("\nPress enter to continue.\n");
					sc.nextLine();
					sc.nextLine();
						break;
					case 10: selectCitation(connection);
					System.out.println("\nPress enter to continue.\n");
					sc.nextLine();
					sc.nextLine();
						break;
					case 11: selectPayment(connection);
					System.out.println("\nPress enter to continue.\n");
					sc.nextLine();
					sc.nextLine();
						break;
					case 12: selectAppeal(connection);
					System.out.println("\nPress enter to continue.\n");
					sc.nextLine();
					sc.nextLine();
						break;
					case 13:
						continue loop;
					default:
	                        System.out.println("Please enter a valid option.");
	                        break;

					
					}
					
				}
			case 2: int insert=0;
			while(insert!=13) {
				System.out.println("1. Insert Drivers");
				System.out.println("2. Insert ParkingLots");
				System.out.println("3. Insert Zones");
				System.out.println("4. Insert SpaceTypes");
				System.out.println("5. Insert Spaces");
				System.out.println("6. Insert Vehicles");
				System.out.println("7. Insert Permits");
				System.out.println("8. Insert Permit Types");
				System.out.println("9. Insert Citations");
				System.out.println("10. Insert Payments");
				System.out.println("11. Insert Appeals");
				System.out.println("12. Insert Citation Categories");
				System.out.println("13. Back to Main Menu");
				System.out.print("Enter Choice: ");
				insert=sc.nextInt();
				switch(insert) {
				case 1: addDriver(connection, sc);
					break;
				case 2: addParkingLot(connection, sc);
					break;
				case 3: addZone(connection, sc);
					break;
				case 4: addSpaceType(connection, sc);
					break;
				case 5: addSpace(connection, sc);
					break;
				case 6:  addVehicle(connection,sc);
					break;
				case 7: createPermit(connection,sc);
					break;
				case 8: createPermitType(connection,sc);
					break;
				case 9: insertCitation(connection, sc);
					break;
				case 10: insertPayment(connection, sc);
					break;
				case 11: insertAppeal(connection, sc);
					break;
				case 12: insertCitationCategory(connection, sc);
					break;
				case 13:
					continue loop;
				 default:
                     System.out.println("Please enter a valid option.");
                     break;

				
				}
			}
			
			case 3: int update=0;
			while(update!=14) {
				System.out.println("1. Update Drivers");
				System.out.println("2. Update ParkingLots");				
				System.out.println("3. Update Spaces");
				System.out.println("4. Update SpaceType in Spaces");
				System.out.println("5. Update SpaceTypes");
				System.out.println("6. Update Vehicles");
				System.out.println("7. Update Permits");
				System.out.println("8. Update Permit Types");
				System.out.println("9. Update vehicle in Permit");
				System.out.println("10. Update Citations");
				System.out.println("11. Update Appeal Status");
				System.out.println("12. Update Citation category Id");
				System.out.println("13. Update Citation Categories");
				System.out.println("14. Back to Main Menu");
				System.out.print("Enter Choice: ");
				update=sc.nextInt();
				switch(update) {
				case 1: updateDriver(connection, sc);
					break;
				case 2: updateParkingLot(connection, sc);
					break;
				case 3: updateSpace(connection, sc);
					break;
				case 4: updateSpaceTypeForSpace(connection, sc);
					break;
				case 5: updateSpaceType(connection, sc);
					break;
				case 6: updateVehicle(connection,sc);
					break;
				case 7: updatePermit(connection,sc);
					break;
				case 8: updatePermitType(connection, sc);
					break;
				case 9: updateVehicleInPermit(connection,sc);
					break;
				case 10: updateCitation(connection, sc);
					break;
				case 11: updateAppealStatus(connection, sc);
					break;
				case 12: updateCitationCategoryID(connection, sc);
					break;
				case 13: updateCitationCategory(connection, sc);
					break;
				case 14:
					continue loop;
				default:
                     System.out.println("Please enter a valid option.");
                     break;

			}
		}
			
			case 4: int delete=0;
			while(delete!=10) {
				System.out.println("1. Delete Drivers");
				System.out.println("2. Delete ParkingLots");				
				System.out.println("3. Delete Zones");
				System.out.println("4. Delete Spaces");
				System.out.println("5. Delete Vehicles");
				System.out.println("6. Delete Permits");
				System.out.println("7. Delete Citations");
				System.out.println("8. Delete Payment");
				System.out.println("9. Delete Appeal");
				System.out.println("10. Back to Main Menu");
				System.out.print("Enter Choice: ");
				insert=sc.nextInt();
				switch(insert) {
				case 1: deleteDriver(connection, sc);
					break;
				case 2: deleteParkingLot(connection, sc);
					break;
				case 3: deleteZone(connection, sc);
					break;
				case 4: deleteSpace(connection, sc);
					break;
				case 5: deleteVehicle(connection,sc);
					break;
				case 6: deletePermit(connection,sc);
					break;
				case 7: deleteCitation(connection, sc);
					break;
				case 8: deletePayment(connection, sc);
					break;
				case 9: deleteAppeal(connection,sc);
					break;
				case 10: 
					continue loop;
				default:
                     System.out.println("Please enter a valid option.");
                     break;

				
				}
			}
				
			case 5: int report=0;
			while(report!=8) {
				System.out.println("1. Report of All citations");
				System.out.println("2. Citation report in a given time range for zones in each lot ");
				System.out.println("3. Report of zones along with their corresponding parking lot as tuple");
				System.out.println("4. Report for active citation violation count ");
				System.out.println("5. Report of number of employees having permits for a given parking zone");
				System.out.println("6. Report to get permit information for given UID_Phone");
				System.out.println("7. Report to get an available space number in a given parkinglot for agiven space type");
				System.out.println("8. Back to main menu");	
				System.out.print("Enter Choice: ");
				insert=sc.nextInt();
				switch(insert) {
				case 1: generateReportForCitations();
				System.out.println("\nPress enter to continue.\n");
				sc.nextLine();
				sc.nextLine();
					break;
				case 2: generateCitationReportInTimeRange(connection,sc);
				System.out.println("\nPress enter to continue.\n");
				sc.nextLine();
				sc.nextLine();
					break;
				case 3: generateParkingLotAndZones();
				System.out.println("\nPress enter to continue.\n");
				sc.nextLine();
				sc.nextLine();
					break;
				case 4: generateActiveCitationViolationCount();
				System.out.println("\nPress enter to continue.\n");
				sc.nextLine();
				sc.nextLine();
					break;
				case 5: generateNoOfEmployeesWithPermitsInZone(connection, sc);
				System.out.println("\nPress enter to continue.\n");
				sc.nextLine();
				sc.nextLine();
					break;
				case 6: generatePermitInfoForUser(connection, sc);
				System.out.println("\nPress enter to continue.\n");
				sc.nextLine();
				sc.nextLine();
					break;
				case 7: generateAvailableSpaceInLot(connection, sc);
				System.out.println("\nPress enter to continue.\n");
				sc.nextLine();
				sc.nextLine();
					break;
				case 8:
					continue loop;
				default:
                     System.out.println("Please enter a valid option.");
                     break;

				}
			}
			case 6:
            	System.out.println("Exiting...\n");
                close();
                System.exit(0);
			 default:
                 System.out.println("Please enter a valid option.");
                 break;
			
			}
		}
	}catch(Throwable oops) {
            oops.printStackTrace();
    }

}
//***************************************************************************************************************************
//HELPER FUNCTIONS

// Returns PermitTypeID for given PermitType
// Returns -1 for invalid PermitType
private static int getPermitTypeIdFromPermitType(Connection connection, String permitType) {
	String sql = "SELECT PermitTypeID FROM PermitTypes WHERE PermitType = ?";
	
	try(PreparedStatement pstmt = connection.prepareStatement(sql)){
		pstmt.setString(1, permitType);
		ResultSet resultSet = pstmt.executeQuery();
		if (resultSet.next()) {
			return resultSet.getInt("PermitTypeID");
		}
		System.out.println("Invalid permit type");
		return -1;
	} catch (SQLException e) {
		e.printStackTrace();
		return -1;
	}
}

//Returns CitationCategoryID for given CitationCategory
//Returns -1 for invalid CitationCategory
private static String getCitationCategoryIdFromCitationCategory(Connection connection, String citationCategory) {
	String sql = "SELECT CitationCategoryID FROM CitationCategories WHERE CitationCategory = ?";
	
	try(PreparedStatement pstmt = connection.prepareStatement(sql)){
		pstmt.setString(1, citationCategory);
		ResultSet resultSet = pstmt.executeQuery();
		if (resultSet.next()) {
			return resultSet.getString("CitationCategoryID");
		}
		System.out.println("Invalid citation category");
		return "";
	} catch (SQLException e) {
		e.printStackTrace();
		return "";
	}
}

//Returns SpaceTypeID for given SpaceType
//Returns -1 for invalid SpaceType
private static int getSpaceTypeIdFromSpaceType(Connection connection, String spaceType) {
	String sql = "SELECT SpaceTypeID FROM SpaceTypes WHERE SpaceType = ?";
	
	try(PreparedStatement pstmt = connection.prepareStatement(sql)){
		pstmt.setString(1, spaceType);
		ResultSet resultSet = pstmt.executeQuery();
		if (resultSet.next()) {
			return resultSet.getInt("SpaceTypeID");
		}
		System.out.println("Invalid space type");
		return -1;
	} catch (SQLException e) {
		e.printStackTrace();
		return -1;
	}
}

//Returns Driver Status for given Driver ID
//Returns "" for invalid Driver ID
private static String getDriverStatus(Connection connection, long uidPhone) {
	String sqlDriver = "SELECT Status FROM Drivers WHERE UID_Phone = ?;";
	try(PreparedStatement pstmt = connection.prepareStatement(sqlDriver)) {
		pstmt.setLong(1, uidPhone);
		ResultSet resultSet = pstmt.executeQuery();
		if (resultSet.next()) {
			return resultSet.getString("Status");	 
		}
		System.out.println("Invalid driver information");
		return "";
	} catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Invalid driver information");
        return "";
    }
}

// Check if driver with status S or E has a 9-digit ID and with status V has a 10-digit ID (phone number) 
private static boolean validateDriverUidPhone(long uidPhone, String status) {
	if (status.equals("S") || status.equals("E")) {
		if (uidPhone >= 100000000 && uidPhone <= 999999999) {
			return true;
		}
		System.out.println("Driver with status as Student or Employee should provide a 9-digit ID.");
		return false;
	}
	if ( status.equals("V") && uidPhone >= 1000000000 && uidPhone < 9999999999L ) {
		return true;
	}
	System.out.println("Driver with status as Visitor should provide a 10-digit ID.");
	return false;
}

/* If driver has status S then a zone "_S" should be assigned in the permit
 If driver has status V then zone "V" should be assigned in the permit
 If driver has status E then a zone "_" (1 character that is not "V") should be assigned in the permit
*/
// Check if driver can be provided a permit for a specific zone
private static boolean validateZoneForDriver(Connection connection, long uidPhone, String zoneId) {
	String driverStatus = getDriverStatus(connection, uidPhone);
	if (driverStatus.equals("")){
		return false;
	}
	if (driverStatus.equals("V") && !zoneId.equals("V")) {
		System.out.println("Driver has a visitor status and can be given a permit for Zone 'V'");
		return false;
	}
	if (driverStatus.equals("S") && (zoneId.length() != 2 || zoneId.charAt(1) != 'S' )) {
		System.out.println("Driver has a student status and can be given a permit for Zones '_S'");
		return false;
	}
	if (driverStatus.equals("E") && (zoneId.length() != 1 || zoneId.equals("V"))) {
		System.out.println("Driver has an employee status and can be given a permit for one character zones that is not Zone 'V'");
		return false;
	}
	return true;
}

// validating if start date is before end date in permit
private static boolean validatePermitDates (String startDate, String endDate) {
	try {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startDateObj = dateFormat.parse(startDate);
        Date endDateObj = dateFormat.parse(endDate);

        if (startDateObj.compareTo(endDateObj) <= 0) {
            return true;
        } else {
            System.out.println("Start date cannot be after the end date.");
            return false;
        }
    } catch (Exception e) {
    	System.out.println("Provide valid start and end dates.");
        return false;
    }
}

/* 
Students and visitors can only have one vehicle on a permit at a time, employees up to 2. 
A total of 1 permit per student, 1 permit per visitor and 2 permits per employee are allowed. 
Students and Employees are allowed an additional permit for special events, or Park & Ride.
 */
// Checks if a driver can be provided a specific type of permit
private static boolean validatePermitCountsForDrivers(Connection connection, long uidPhone, int permitTypeId) {
	String driverStatus = getDriverStatus(connection, uidPhone);
	if (driverStatus.equals("")){
		return false;
	}
	
	String sqlParkRideSpecialEvent = "SELECT COUNT(*) AS Count FROM Permits WHERE UID_Phone = ? AND PermitTypeID IN (4, 5)";
	String sqlNOTParkRideSpecialEvent = "SELECT COUNT(*) AS Count FROM Permits WHERE UID_Phone = ? AND PermitTypeID NOT IN (4, 5)";
	
	int countParkRideSpecialEvent = 0;
	int countNOTParkRideSpecialEvent = 0;
	
	try(PreparedStatement pstmt = connection.prepareStatement(sqlParkRideSpecialEvent)){
		pstmt.setLong(1, uidPhone);
		ResultSet resultSet = pstmt.executeQuery();
		if (resultSet.next()) {
			countParkRideSpecialEvent = resultSet.getInt("Count");
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	try(PreparedStatement pstmt = connection.prepareStatement(sqlNOTParkRideSpecialEvent)){
		pstmt.setLong(1, uidPhone);
		ResultSet resultSet = pstmt.executeQuery();
		if (resultSet.next()) {
			countNOTParkRideSpecialEvent = resultSet.getInt("Count");	 
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	int totalCount = countParkRideSpecialEvent + countNOTParkRideSpecialEvent;
	
	if(driverStatus.equals("V") && totalCount == 1) {
		System.out.println("The mentioned driver has a visitor status and already has 1 active permit");
		return false;
	}
	if(driverStatus.equals("S") && totalCount == 2) {
		System.out.println("The mentioned driver has a student status and already has 2 active permits (including one Park & Ride or Special Event permit)");
		return false;
	} 
	if(driverStatus.equals("S") && countParkRideSpecialEvent == 1) {
		return true;
	}
	if(driverStatus.equals("S") && countNOTParkRideSpecialEvent == 1) {
		if (permitTypeId == 4 || permitTypeId == 5) {
			return true;
		}
		System.out.println("The mentioned driver has a student status and already has 1 active permit (other than Park & Ride and Special Event permits). The driver can request for a Park & Ride or Special Event permit only.");
		return false;
	}
	if(driverStatus.equals("E") && totalCount == 3) {
		System.out.println("The mentioned driver has an employee status and already has 3 active permits (including one Park & Ride or Special Event permit)");
		return false;
	}
	if(driverStatus.equals("E") && countParkRideSpecialEvent == 2) {
		return true;
	} 
	if(driverStatus.equals("E") && countParkRideSpecialEvent == 1 && countNOTParkRideSpecialEvent == 1) {
		return true;
	} 
	if(driverStatus.equals("E") && countNOTParkRideSpecialEvent == 2) {
		if(permitTypeId == 4 || permitTypeId == 5) {
			return true;
		}
		System.out.println("The mentioned driver has an employee status and already has 2 active permits (other than Park & Ride and Special Event permits). The driver can request for a Park & Ride or Special Event permit only.");
		return false;
	}
	return true;
}



//***************************************************************************************************************************
//SELECT TABLE FUNCTIONS
	//Select Vehicles
	public static void selectVehicle(Connection connection) throws SQLException {
		String sql= "select CarLicenceNumber, Model, Year, Manufacturer, Color from Vehicles";	
		try(Statement stmt= connection.createStatement()) {
			ResultSet resultSet = stmt.executeQuery(sql);
			 int columnCount = resultSet.getMetaData().getColumnCount();
		        for (int i = 1; i <= columnCount; i++) {
		            System.out.printf("%-15s", resultSet.getMetaData().getColumnName(i));
		        }
	        System.out.println();

	        // Display data
	        while (resultSet.next()) {
	            for (int i = 1; i <= columnCount; i++) {
	                System.out.printf("%-15s", resultSet.getString(i));
	            }
	            System.out.println();
	        }
		}
	}
	
	//Select Drivers
	public static void selectDriver(Connection connection) throws SQLException {
		String sql= "select Name, Status, UID_Phone from Drivers";
		try(Statement stmt= connection.createStatement()) {
//			 result= stmt.executeQuery(sql);
			 ResultSet resultSet = stmt.executeQuery(sql);
			 int columnCount = resultSet.getMetaData().getColumnCount();
		        for (int i = 1; i <= columnCount; i++) {
		            System.out.printf("%-15s", resultSet.getMetaData().getColumnName(i));
		        }
		        System.out.println();

		        // Display data
		        while (resultSet.next()) {
		            for (int i = 1; i <= columnCount; i++) {
		                System.out.printf("%-15s", resultSet.getString(i));
		            }
		            System.out.println();
		        }}
	}
	
	//Select ParkingLots
	public static void selectParkingLot(Connection connection) throws SQLException {
		String sql= "select Name, ParkingLotID, Address from ParkingLots";
		try(Statement stmt= connection.createStatement()) {
			ResultSet resultSet = stmt.executeQuery(sql);
			 int columnCount = resultSet.getMetaData().getColumnCount();
		        for (int i = 1; i <= columnCount; i++) {
		            System.out.printf("%-15s", resultSet.getMetaData().getColumnName(i));
		        }
		        System.out.println();

		        // Display data
		        while (resultSet.next()) {
		            for (int i = 1; i <= columnCount; i++) {
		                System.out.printf("%-15s", resultSet.getString(i));
		            }
		            System.out.println();
		        }}
	}
	
	//Select Zones
	public static void selectZone(Connection connection) throws SQLException {
		String sql= "select ZoneID, ParkingLotID from Zones";
		try(Statement stmt= connection.createStatement()) {
			ResultSet resultSet = stmt.executeQuery(sql);
			 int columnCount = resultSet.getMetaData().getColumnCount();
		        for (int i = 1; i <= columnCount; i++) {
		            System.out.printf("%-15s", resultSet.getMetaData().getColumnName(i));
		        }
		        System.out.println();

		        // Display data
		        while (resultSet.next()) {
		            for (int i = 1; i <= columnCount; i++) {
		                System.out.printf("%-15s", resultSet.getString(i));
		            }
		            System.out.println();
		        }}
	}
	
	//Select SpaceTypes
	public static void selectSpaceType(Connection connection) throws SQLException {
		String sql= "select SpaceTypeID, SpaceType from SpaceTypes";
		try(Statement stmt= connection.createStatement()) {
			ResultSet resultSet = stmt.executeQuery(sql);
			 int columnCount = resultSet.getMetaData().getColumnCount();
		        for (int i = 1; i <= columnCount; i++) {
		            System.out.printf("%-15s", resultSet.getMetaData().getColumnName(i));
		        }
		        System.out.println();

		        // Display data
		        while (resultSet.next()) {
		            for (int i = 1; i <= columnCount; i++) {
		                System.out.printf("%-15s", resultSet.getString(i));
		            }
		            System.out.println();
		        }}
	}
	
	//Select Spaces
	public static void selectSpace(Connection connection) throws SQLException {
		String sql= "select SpaceNumber, ZoneID, pl.Name as ParkingLotName, AvailabilityStatus, SpaceType from Spaces s join SpaceTypes st on s.SpaceTypeID = st.SpaceTypeID join ParkingLots pl on s.ParkingLotID = pl.ParkingLotID";
		try(Statement stmt= connection.createStatement()) {
			ResultSet resultSet = stmt.executeQuery(sql);
			 int columnCount = resultSet.getMetaData().getColumnCount();
		        for (int i = 1; i <= columnCount; i++) {
		            System.out.printf("%-15s", resultSet.getMetaData().getColumnName(i));
		        }
		        System.out.println();

		        // Display data
		        while (resultSet.next()) {
		            for (int i = 1; i <= columnCount; i++) {
		                System.out.printf("%-15s  ", resultSet.getString(i));
		            }
		            System.out.println();
		        }}
	}
	
	//Select PermitTypes
	public static void selectPermitType(Connection connection) throws SQLException {
		String sql= "select PermitTypeID, PermitType from PermitTypes";
		try(Statement stmt= connection.createStatement()) {
			ResultSet resultSet = stmt.executeQuery(sql);
			 int columnCount = resultSet.getMetaData().getColumnCount();
		        for (int i = 1; i <= columnCount; i++) {
		            System.out.printf("%-15s", resultSet.getMetaData().getColumnName(i));
		        }
		        System.out.println();

		        // Display data
		        while (resultSet.next()) {
		            for (int i = 1; i <= columnCount; i++) {
		                System.out.printf("%-15s", resultSet.getString(i));
		            }
		            System.out.println();
		        }}
	}
	
	//Select Permits
	public static void selectPermit(Connection connection) throws SQLException {
		String sql= "select PermitID, StartDate, ExpirationDate, ExpirationTime, PermitType, pl.Name as ParkingLotName, ZoneID, SpaceType, UID_Phone, CarLicenceNumber from Permits p join PermitTypes pt on p.PermitTypeID = pt.PermitTypeID join ParkingLots pl on p.ParkingLotID = pl.ParkingLotID join SpaceTypes st on p.SpaceTypeID = st.SpaceTypeID";
		try(Statement stmt= connection.createStatement()) {
			ResultSet resultSet = stmt.executeQuery(sql);
			 int columnCount = resultSet.getMetaData().getColumnCount();
		        for (int i = 1; i <= columnCount; i++) {
		            System.out.printf("%-15s", resultSet.getMetaData().getColumnName(i));
		        }
		        System.out.println();

		        // Display data
		        while (resultSet.next()) {
		            for (int i = 1; i <= columnCount; i++) {
		                System.out.printf("%-15s", resultSet.getString(i));
		            }
		            System.out.println();
		        }}
	}
	
	//Select Citation Categories
	public static void selectCitationCategory(Connection connection) throws SQLException {
			String sql= "select CitationCategoryID, CitationCategory, Fee from CitationCategories";
			try(Statement stmt= connection.createStatement()) {
				ResultSet resultSet = stmt.executeQuery(sql);
				 int columnCount = resultSet.getMetaData().getColumnCount();
			        for (int i = 1; i <= columnCount; i++) {
			            System.out.printf("%-15s", resultSet.getMetaData().getColumnName(i));
			        }
			        System.out.println();

			        // Display data
			        while (resultSet.next()) {
			            for (int i = 1; i <= columnCount; i++) {
			                System.out.printf("%-15s", resultSet.getString(i));
			            }
			            System.out.println();
			        }}
		}
	
	//Select citations
	public static void selectCitation(Connection connection) throws SQLException {
		String sql= "select CitationNumber, CitationDate, CitationTime, PaymentStatus, CitationCategory, CarLicenseNumber, pl.Name as ParkingLotName, ZoneID, SpaceNumber from Citations c join CitationCategories cc on c.CitationCategoryID = cc.CitationCategoryID join ParkingLots pl on c.ParkingLotID = pl.ParkingLotID";
		try(Statement stmt= connection.createStatement()) {
			ResultSet resultSet = stmt.executeQuery(sql);
			 int columnCount = resultSet.getMetaData().getColumnCount();
		        for (int i = 1; i <= columnCount; i++) {
		            System.out.printf("%-15s", resultSet.getMetaData().getColumnName(i));
		        }
		        System.out.println();

		        // Display data
		        while (resultSet.next()) {
		            for (int i = 1; i <= columnCount; i++) {
		                System.out.printf("%-15s", resultSet.getString(i));
		            }
		            System.out.println();
		        }}
	}
	
	//Select Payments
	public static void selectPayment(Connection connection) throws SQLException {
		String sql= "select PaymentID, PaymentDate, PaymentTime, Amount, CitationNumber from Payments";
		try(Statement stmt= connection.createStatement()) {
			ResultSet resultSet = stmt.executeQuery(sql);
			 int columnCount = resultSet.getMetaData().getColumnCount();
		        for (int i = 1; i <= columnCount; i++) {
		            System.out.printf("%-15s", resultSet.getMetaData().getColumnName(i));
		        }
		        System.out.println();

		        // Display data
		        while (resultSet.next()) {
		            for (int i = 1; i <= columnCount; i++) {
		                System.out.printf("%-15s", resultSet.getString(i));
		            }
		            System.out.println();
		        }}
	}
	
	//Select Appeals
	public static void selectAppeal(Connection connection) throws SQLException {
		String sql= "select AppealID, AppealDescription, AppealStatus, CitationNumber from Appeals";
		try(Statement stmt= connection.createStatement()) {
			ResultSet resultSet = stmt.executeQuery(sql);
			 int columnCount = resultSet.getMetaData().getColumnCount();
		        for (int i = 1; i <= columnCount; i++) {
		            System.out.printf("%-15s\t\t", resultSet.getMetaData().getColumnName(i));
		        }
		        System.out.println();

		        // Display data
		        while (resultSet.next()) {
		            for (int i = 1; i <= columnCount; i++) {
		                System.out.printf("%-15s\t\t", resultSet.getString(i));
		            }
		            System.out.println();
		        }}
	}
	


//***************************************************************************************************************************

// TASK AND OPERATIONS : 1 : INFORMATION PROCESSING
	
	// Add driver info
	public static void addDriver(Connection conn,Scanner sc) {
		
		long uidPhone = -1;
		String status = "";
		do {
			System.out.println("Enter UID or Phone Number: ");
			uidPhone = sc.nextLong();
        
			System.out.println("Enter Status: ");
			status = sc.next();
		} while (!validateDriverUidPhone(uidPhone, status));
        
        System.out.println("Enter Name: ");
        String name = sc.next();
        
	    String sql = "INSERT INTO Drivers (UID_Phone, Name, Status) VALUES (?, ?, ?)";
	    
	    try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
	        pstmt.setLong(1, uidPhone);
	        pstmt.setString(2, name);
	        pstmt.setString(3, status);
	        
	        pstmt.executeUpdate();
					sc.nextLine();
	        connection.commit();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	// Update driver info
	public static void updateDriver(Connection conn,Scanner sc) {
		
		System.out.println("Existing data from Drivers");
		try {
			selectDriver(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Enter UID or Phone to update: ");
        long uidPhone = sc.nextLong();
        
		String status = "";
		do {
			System.out.println("Enter Status: ");
			status = sc.next();
		} while (!validateDriverUidPhone(uidPhone, status));
        
		sc.nextLine();
        System.out.println("Enter Name: ");
        String name = sc.nextLine();
		
	    String sql = "UPDATE Drivers SET Name = ?, Status = ? WHERE UID_Phone = ?";
	    
	    try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
	        pstmt.setString(1, name);
	        pstmt.setString(2, status);
	        pstmt.setLong(3, uidPhone);
	        
	        pstmt.executeUpdate();
	        sc.nextLine();
	        connection.commit();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	// Delete driver info
	public static void deleteDriver(Connection conn,Scanner sc) {
		System.out.println("Enter UID/Phone to delete: ");
        long uidPhone = sc.nextLong();
        
	    String sql = "DELETE FROM Drivers WHERE UID_Phone = ?";
	    
	    try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
	        pstmt.setLong(1, uidPhone);
	        
	        pstmt.executeUpdate();
					sc.nextLine();
	        connection.commit();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	// Add parking lot info
	public static void addParkingLot(Connection conn,Scanner sc) {
		
        
        System.out.println("Enter Name: ");
        String name = sc.next();
        
        System.out.println("Enter Address: ");
        String address = sc.next();
        
	    String sql = "INSERT INTO ParkingLots (ParkingLotID, Name, Address) VALUES (NULL, ?, ?)";
	    
	    try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
	        //pstmt.setInt(1, parkingLotID);
	        pstmt.setString(1, name);
	        pstmt.setString(2, address);
	        
	        pstmt.executeUpdate();
					sc.nextLine();
	        connection.commit();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	// Update parking lot info
	public static void updateParkingLot(Connection conn,Scanner sc) {
		
		System.out.println("Existing data from Parking Lots");
		try {
			selectParkingLot(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		sc.nextLine();
		System.out.println("Enter Parking Lot to update : ");
        String parkingLot = sc.nextLine();
        sc.nextLine();
        System.out.println("Enter Name: ");
        String name = sc.nextLine();
        sc.nextLine();
        System.out.println("Enter Address: ");
        String address = sc.nextLine();
		
	    String sql = "UPDATE ParkingLots SET Name = ?, Address = ? WHERE Name = ?";
	    
	    try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
	        pstmt.setString(1, name);
	        pstmt.setString(2, address);
	    	pstmt.setString(3, parkingLot);
	        
	        pstmt.executeUpdate();
					sc.nextLine();
	        connection.commit();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	// Delete parking lot info
	public static void deleteParkingLot(Connection conn,Scanner sc) {
		System.out.println("Enter Parking Lot id to delete: ");
        int parkingLot = sc.nextInt();
        
	    String sql = "DELETE FROM ParkingLots WHERE ParkingLotID = ?";
	    
	    try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
	        pstmt.setInt(1, parkingLot);
	        
	        pstmt.executeUpdate();
					sc.nextLine();
	        connection.commit();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	// Add zone info
	public static void addZone(Connection conn,Scanner sc) {
		System.out.println("Enter Parking Lot: ");
        String parkingLot = sc.next();
		
		System.out.println("Enter Zone ID: ");
        String zoneID = sc.next();
        
        int parkingLotID = 0;
        String sql= "select ParkingLotID from ParkingLots where Name = ?;";
	   	 try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
	   		 preparedStatement.setString(1, parkingLot);
	            try (ResultSet resultSet = preparedStatement.executeQuery()) {
	                while (resultSet.next()) {
	                	parkingLotID = resultSet.getInt("ParkingLotID");
	                }
	            }
	   	 } catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
	    String sql1 = "INSERT INTO Zones (ParkingLotID, ZoneID) VALUES (?, ?)";
	    
	    try (PreparedStatement pstmt = connection.prepareStatement(sql1)) {
	        pstmt.setInt(1, parkingLotID);
	        pstmt.setString(2, zoneID);
	        
	        pstmt.executeUpdate();
					sc.nextLine();
	        connection.commit();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	// Delete zone info
	public static void deleteZone(Connection conn,Scanner sc) {
		System.out.println("Enter Parking Lot ID: ");
        int parkingLotID = sc.nextInt();
        sc.nextLine();
		
		System.out.println("Enter Zone ID: ");
        String zoneID = sc.next();
        
        
	    String sql1 = "DELETE FROM Zones WHERE ZoneID = ? AND ParkingLotID = ?";
	    
	    try (PreparedStatement pstmt = connection.prepareStatement(sql1)) {
	        pstmt.setString(1, zoneID);
	        pstmt.setInt(2, parkingLotID);
	        
	        pstmt.executeUpdate();
					sc.nextLine();
	        connection.commit();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	// Add space info
	public static void addSpace(Connection conn,Scanner sc) {
		System.out.println("Enter Parking Lot: ");
        String parkingLot = sc.next();
		
		System.out.println("Enter Zone ID: ");
        String zoneID = sc.next();
        
        int parkingLotID = 0;
        String sql= "select ParkingLotID from ParkingLots where Name = ?;";
	   	 System.out.println(sql);
	   	 try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
	   		 preparedStatement.setString(1, parkingLot);
	            try (ResultSet resultSet = preparedStatement.executeQuery()) {
	                while (resultSet.next()) {
	                	parkingLotID = resultSet.getInt("ParkingLotID");
	                }
	            }
	   	 } catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        String spaceType = "";
        int spaceTypeID = -1;
        do {
        	System.out.println("Enter Space Type: ");
            spaceType = sc.next();
            spaceTypeID = getSpaceTypeIdFromSpaceType(conn, spaceType);
        } while (spaceTypeID == -1);
        
        System.out.println("Enter Space Number: ");
        int spaceNumber = sc.nextInt();
        
        System.out.println("Enter Availability Status: ");
        String availabilityStatus = sc.next();
        
	    String sql2 = "INSERT INTO Spaces (ParkingLotID, ZoneID, SpaceNumber, AvailabilityStatus, SpaceTypeID) VALUES (?, ?, ?, ?, ?)";
	    
	    try (PreparedStatement pstmt = connection.prepareStatement(sql2)) {
	        pstmt.setInt(1, parkingLotID);
	        pstmt.setString(2, zoneID);
	        pstmt.setInt(3, spaceNumber);
	        pstmt.setString(4, availabilityStatus);
	        pstmt.setInt(5, spaceTypeID);
	        
	        pstmt.executeUpdate();
					sc.nextLine();
	        connection.commit();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	// Update space info
	public static void updateSpace(Connection conn,Scanner sc) {
		
		System.out.println("Existing data from Spaces");
		try {
			selectSpace(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		sc.nextLine();
		System.out.println("Enter Parking Lot: ");
        String parkingLot = sc.nextLine();
        sc.nextLine();
		System.out.println("Enter Zone ID: ");
        String zoneID = sc.nextLine();
        
        int parkingLotID = 0;
        String sql= "select ParkingLotID from ParkingLots where Name = ?;";
	   	 System.out.println(sql);
	   	 try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
	   		 preparedStatement.setString(1, parkingLot);
	            try (ResultSet resultSet = preparedStatement.executeQuery()) {
	                while (resultSet.next()) {
	                	parkingLotID = resultSet.getInt("ParkingLotID");
	                }
	            }
	   	 } catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        System.out.println("Enter Space Number to update: ");
        int spaceNumber = sc.nextInt();
        
        System.out.println("Enter Availability Status: ");
        String availabilityStatus = sc.next();
		
	    String sql1 = "UPDATE Spaces SET AvailabilityStatus = ? WHERE ParkingLotID = ? AND ZoneID = ? AND SpaceNumber = ?";
	    
	    try (PreparedStatement pstmt = connection.prepareStatement(sql1)) {
	        pstmt.setString(1, availabilityStatus);
	        pstmt.setInt(2, parkingLotID);
	        pstmt.setString(3, zoneID);
	        pstmt.setInt(4, spaceNumber);
	        
	        pstmt.executeUpdate();
					sc.nextLine();
	        connection.commit();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	// Delete space info
	public static void deleteSpace(Connection conn,Scanner sc) {
		System.out.println("Enter Parking Lot ID: ");
        int parkingLotID = sc.nextInt();
		
		System.out.println("Enter Zone ID: ");
        String zoneID = sc.next();
        
        System.out.println("Enter Space Number to delete: ");
        int spaceNumber = sc.nextInt();
        
	    String sql1 = "DELETE FROM Spaces WHERE ParkingLotID = ? AND ZoneID = ? AND SpaceNumber = ?";
	    
	    try (PreparedStatement pstmt = connection.prepareStatement(sql1)) {
	    	pstmt.setInt(1, parkingLotID);
	        pstmt.setString(2, zoneID);
	        pstmt.setInt(3, spaceNumber);
	        
	        pstmt.executeUpdate();
					sc.nextLine();
	        connection.commit();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	// Update space type in space
	public static void updateSpaceTypeForSpace(Connection conn,Scanner sc) {
		System.out.println("Existing data from Spaces");
		try {
			selectSpace(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		sc.nextLine();
		System.out.println("Enter Parking Lot: ");
        String parkingLot = sc.nextLine();
        sc.nextLine();
		System.out.println("Enter Zone ID: ");
        String zoneID = sc.nextLine();
        
        int parkingLotID = 0;
        String sql= "select ParkingLotID from ParkingLots where Name = ?;";
	   	 System.out.println(sql);
	   	 try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
	   		 preparedStatement.setString(1, parkingLot);
	            try (ResultSet resultSet = preparedStatement.executeQuery()) {
	                while (resultSet.next()) {
	                	parkingLotID = resultSet.getInt("ParkingLotID");
	                }
	            }
	   	 } catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        System.out.println("Enter Space Number to update: ");
        int spaceNumber = sc.nextInt();
        
        String spaceType = "";
        int spaceTypeID = -1;
        do {
        	System.out.println("Enter Space Type: ");
            spaceType = sc.next();
            spaceTypeID = getSpaceTypeIdFromSpaceType(conn, spaceType);
        } while (spaceTypeID == -1);
		
	    String sql1 = "UPDATE Spaces SET SpaceTypeID = ? WHERE ParkingLotID = ? AND ZoneID = ? AND SpaceNumber = ?";
	    
	    try (PreparedStatement pstmt = connection.prepareStatement(sql1)) {
	        pstmt.setInt(1, spaceTypeID);
	        pstmt.setInt(2, parkingLotID);
	        pstmt.setString(3, zoneID);
	        pstmt.setInt(4, spaceNumber);
	        
	        pstmt.executeUpdate();
					sc.nextLine();
	        connection.commit();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	// Add space type info
	public static void addSpaceType(Connection conn,Scanner sc) {
		System.out.println("Enter Space Type: ");
        String spaceType = sc.next();
        
	    String sql = "INSERT INTO SpaceTypes (SpaceType) VALUES (?)";
	    
	    try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
	        pstmt.setString(1, spaceType);
	        
	        pstmt.executeUpdate();
					sc.nextLine();
	        connection.commit();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	// Update space type info
	public static void updateSpaceType(Connection conn,Scanner sc) {
        
		System.out.println("Existing data from Space Types");
		try {
			selectSpaceType(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		sc.nextLine();
        System.out.println("Enter Space Type ID to update: ");
        int spaceTypeID = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Space Type: ");
        String spaceType = sc.next();
		
	    String sql = "UPDATE SpaceTypes SET SpaceType = ? WHERE SpaceTypeID = ?";
	    
	    try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
	        pstmt.setString(1, spaceType);
	        pstmt.setInt(2, spaceTypeID);
	        
	        pstmt.executeUpdate();
					sc.nextLine();
	        connection.commit();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}


//***************************************************************************************************************************

// TASK AND OPERATIONS : 2 : MAINTAINING PERMIT AND VEHICLE INFORMATION 

	//Add vehicle info
	public static void addVehicle(Connection conn,Scanner sc) {
		System.out.println("Enter Car License Number: ");
        String carLicenseNumber = sc.next();
        
        System.out.println("Enter Model: ");
        String model = sc.next();
        
        System.out.println("Enter Year: ");
        int year = sc.nextInt();
        
        System.out.println("Enter Manufacturer: ");
        String manufacturer = sc.next();
        
        System.out.println("Enter Color: ");
        String color = sc.next();
        
	    String sql = "INSERT INTO Vehicles (CarLicenceNumber, Model, Year, Manufacturer, Color) VALUES (?, ?, ?, ?, ?)";
	    
	    try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
	        pstmt.setString(1, carLicenseNumber);
	        pstmt.setString(2, model);
	        pstmt.setInt(3, year);
	        pstmt.setString(4, manufacturer);
	        pstmt.setString(5, color);
	        
	        pstmt.executeUpdate();
					sc.nextLine();
	        connection.commit();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}


	//Update Vehicle info
	public static void updateVehicle(Connection conn,Scanner sc) {
		System.out.println("Existing data from Vehicles");
		try {
			selectVehicle(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		 System.out.println("Enter Car License Number to update: ");
         String carLicenseNumberToUpdate = sc.next();
         sc.nextLine();
         System.out.println("Enter Model: ");
         String modelToUpdate = sc.nextLine();
         
         System.out.println("Enter Year: ");
         int yearToUpdate = sc.nextInt();
         
         sc.nextLine();
         System.out.println("Enter Manufacturer: ");
         String manufacturerToUpdate = sc.nextLine();
         sc.nextLine();
         
         System.out.println("Enter Color: ");
         String colorToUpdate = sc.nextLine();
				 sc.nextLine();
		
	    String sql = "UPDATE Vehicles SET Model = ?, Year = ?, Manufacturer = ?, Color = ? WHERE CarLicenceNumber = ?";
	    
	    try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
	        pstmt.setString(1, modelToUpdate);
	        pstmt.setInt(2, yearToUpdate);
	        pstmt.setString(3, manufacturerToUpdate);
	        pstmt.setString(4, colorToUpdate);
	        pstmt.setString(5, carLicenseNumberToUpdate);
	        
	        pstmt.executeUpdate();
					sc.nextLine();
	        connection.commit();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}


	//Delete Vehicle info
	public static void deleteVehicle(Connection conn,Scanner sc) {
		System.out.println("Enter Car License Number to delete: ");
        String carLicenseNumberToDelete = sc.next();
        
	    String sql = "DELETE FROM Vehicles WHERE CarLicenceNumber = ?";
	    
	    try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
	        pstmt.setString(1, carLicenseNumberToDelete);
	        
	        pstmt.executeUpdate();
					sc.nextLine();
	        connection.commit();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	/* 
	Students and visitors can only have one vehicle on a permit at a time, employees up to 2. 
	A total of 1 permit per student, 1 permit per visitor and 2 permits per employee are allowed. 
	Students and Employees are allowed an additional permit for special events, or Park & Ride.
	 */
	//Create a Permit for Student/Visitor or Faculty
	public static void createPermit(Connection conn,Scanner sc) {
		System.out.println("Enter UID or Phone: ");
        long uidPhone = sc.nextLong();
        
        int permitTypeId = -1;
        String permitType = "";
        
        do {
        	System.out.println("Enter Permit Type: ");
            permitType = sc.next();
            permitTypeId = getPermitTypeIdFromPermitType(conn, permitType);
        } while (permitTypeId == -1);
        
        
        if (!validatePermitCountsForDrivers(conn, uidPhone, permitTypeId)) {
        	return;
        }
        
        int parkingLotId = -1;
        String zoneId = "";
        do {
        	System.out.println("Enter Parking Lot ID: ");
        	parkingLotId = sc.nextInt();
        	System.out.println("Enter Zone ID: ");
            zoneId = sc.next();
        } while (!validateZoneForDriver(conn, uidPhone, zoneId));
		
		System.out.println("Enter Permit ID: ");
        String permitId = sc.next();
        
        String startDate = "";
        String expirationDate = "";
        do {
        	System.out.println("Enter Start Date (YYYY-MM-DD): ");
            startDate = sc.next();
            System.out.println("Enter Expiration Date (YYYY-MM-DD): ");
            expirationDate = sc.next();
        } while (!validatePermitDates(startDate, expirationDate));
        
        System.out.println("Enter Expiration Time (HH:MM:SS): ");
        String expirationTime = sc.next();
        
        System.out.println("Enter Space Type ID: ");
        int spaceTypeId = sc.nextInt();
        
        System.out.println("Enter Car License Number: ");
        String carLicenseNumber = sc.next();
		
        String sql= "INSERT INTO Permits(PermitID, StartDate, ExpirationDate, ExpirationTime, PermitTypeID, ParkingLotID, ZoneID, SpaceTypeID, UID_Phone, CarlicenceNumber) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		
		try(PreparedStatement pstmt = connection.prepareStatement(sql)){
			pstmt.setString(1, permitId);
	        pstmt.setString(2, startDate);
	        pstmt.setString(3, expirationDate);
	        pstmt.setString(4, expirationTime);
	        pstmt.setInt(5, permitTypeId);
	        pstmt.setInt(6, parkingLotId);
	        pstmt.setString(7, zoneId);
	        pstmt.setInt(8, spaceTypeId);
	        pstmt.setLong(9, uidPhone);
	        pstmt.setString(10, carLicenseNumber);
	        
	        pstmt.executeUpdate();
					sc.nextLine();
	        connection.commit();
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	//Update Permit Info
	public static void updatePermit(Connection conn,Scanner sc) {
		System.out.println("Existing data from Permits");
		try {
			selectPermit(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Enter Permit ID to update: ");
        String permitIdToUpdate = sc.next();
        
        System.out.println("Enter UID or Phone: ");
        long updatedUidPhone = sc.nextLong();
        
        String updatedPermitType = "";
        int updatedPermitTypeId = -1;
        
        do {
        	System.out.println("Enter Permit Type: ");
            updatedPermitType = sc.nextLine();
						sc.nextLine();
            updatedPermitTypeId = getPermitTypeIdFromPermitType(conn, updatedPermitType);
        } while (updatedPermitTypeId == -1);
        
        
        if (!validatePermitCountsForDrivers(conn, updatedUidPhone, updatedPermitTypeId)) {
        	return;
        }
        
        int updatedParkingLotId = -1;
    	
        String updatedZoneId = "";
        do {
        	System.out.println("Enter Parking Lot: ");
        	String updatedParkingLot = sc.nextLine();
        	sc.nextLine();
        	String sql= "select ParkingLotID from ParkingLots where Name = ?;";
   	   	 try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
   	   		 preparedStatement.setString(1, updatedParkingLot);
   	            try (ResultSet resultSet = preparedStatement.executeQuery()) {
   	                while (resultSet.next()) {
   	                	updatedParkingLotId = resultSet.getInt("ParkingLotID");
   	                }
   	            }
   	   	 } catch (SQLException e1) {
   			// TODO Auto-generated catch block
   			e1.printStackTrace();
   		}
        	System.out.println("Enter Zone ID: ");
            updatedZoneId = sc.next();
        } while (!validateZoneForDriver(conn, updatedUidPhone, updatedZoneId));
        
        String updatedStartDate = "";
        String updatedExpirationDate = "";
        do {
        	System.out.println("Enter Start Date (YYYY-MM-DD): ");
            updatedStartDate = sc.next();
            System.out.println("Enter Expiration Date (YYYY-MM-DD): ");
            updatedExpirationDate = sc.next();
        } while (!validatePermitDates(updatedStartDate, updatedExpirationDate));
        
        System.out.println("Enter Expiration Time (HH:MM:SS): ");
        String updatedExpirationTime = sc.next();
        
        System.out.println("Enter Space Type ID: ");
        int updatedSpaceTypeId = sc.nextInt();
        
        System.out.println("Enter Car License Number: ");
        String updatedCarLicenseNumber = sc.next();
        
	    String sql = "UPDATE Permits SET StartDate = ?, ExpirationDate = ?, ExpirationTime = ?, PermitTypeID = ?, ParkingLotID = ?, ZoneID = ?, SpaceTypeID = ?, UID_Phone = ?, CarLicenceNumber = ? WHERE PermitID = ?";
	    
	    try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
	        pstmt.setString(1, updatedStartDate);
	        pstmt.setString(2, updatedExpirationDate);
	        pstmt.setString(3, updatedExpirationTime);
	        pstmt.setInt(4, updatedPermitTypeId);
	        pstmt.setInt(5, updatedParkingLotId);
	        pstmt.setString(6, updatedZoneId);
	        pstmt.setInt(7, updatedSpaceTypeId);
	        pstmt.setLong(8, updatedUidPhone);
	        pstmt.setString(9, updatedCarLicenseNumber);
	        pstmt.setString(10, permitIdToUpdate);
	        
	        pstmt.executeUpdate();
					sc.nextLine();
	        connection.commit();
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	
	//Delete any permit
	public static void deletePermit(Connection conn,Scanner sc) {
		
		System.out.println("Enter Permit ID to delete: ");
        String permitIdToDelete = sc.next();
        
	    String sql = "DELETE FROM Permits WHERE PermitID = ?";
	    
	    try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
	        pstmt.setString(1, permitIdToDelete);
	        
	        pstmt.executeUpdate();
					sc.nextLine();
	        connection.commit();
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	
	// Create a Permit Type(already given or any to be added in future) 
	public static void createPermitType(Connection conn,Scanner sc) {
		
		System.out.println("Enter Permit Type: ");
        String permitType = sc.next();
        
        System.out.println("Enter Permit Type ID: ");
        int permitTypeId = sc.nextInt();
		
	    String sql = "INSERT INTO PermitTypes (PermitType, PermitTypeID) VALUES (?, ?)";
	    
	    try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
	        pstmt.setString(1, permitType);
	        pstmt.setInt(2, permitTypeId);
	        
	        pstmt.executeUpdate();
					sc.nextLine();
	        connection.commit();
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	
	// Update Permit Type info
	public static void updatePermitType(Connection conn,Scanner sc) {
		System.out.println("Existing data from Permit Types");
		try {
			selectPermitType(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
        System.out.println("Enter Permit Type: ");
        String updatedPermitType = sc.nextLine();
				sc.nextLine();
        
        System.out.println("Enter Permit Type ID: ");
        int permitTypeIdToUpdate = sc.nextInt();
        
	    String sql = "UPDATE PermitTypes SET PermitType = ? WHERE PermitTypeID = ?";
	    
	    try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
	        pstmt.setString(1, updatedPermitType);
	        pstmt.setInt(2, permitTypeIdToUpdate);
	        
	        pstmt.executeUpdate();
					sc.nextLine();
	        connection.commit();
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	
	//Update any vehicle info in a Permit. For example a student buys a new car and wants to add it to his/her existing permit
	public static void updateVehicleInPermit(Connection conn,Scanner sc) {
		System.out.println("Existing data from Permits");
		try {
			selectPermit(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Enter Car License Number to update in permit: ");
        String carLicenseNumberToUpdateInPermit = sc.next();
        
        System.out.println("Enter Permit ID: ");
        String permitIdToUpdate1 = sc.next();
        
	    String sql = "UPDATE Permits SET CarLicenceNumber = ? WHERE PermitID = ?";
	    
	    try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
	        pstmt.setString(1, carLicenseNumberToUpdateInPermit);
	        pstmt.setString(2, permitIdToUpdate1);
	        
	        pstmt.executeUpdate();
					sc.nextLine();
	        connection.commit();
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

//***************************************************************************************************************************

// TASK AND OPERATIONS : 3 : GENERATIONG AND MAINTAING CITATIONS
	// Create Citation (Payment Status by default Unpaid
	private static void insertCitation(Connection conn,Scanner scanner) {    
		System.out.print("Enter Citation Number: ");
        String cnumber = scanner.nextLine();
        scanner.nextLine();
        
		System.out.print("Enter Citation Date (YYYY-MM-DD): ");
        String cdt = scanner.nextLine();
        scanner.nextLine();
        
        System.out.print("Enter Citation Time (HH:MM:SS): ");
        String ctm = scanner.nextLine();
        scanner.nextLine();
        
        String cc = "";
        String ccid = "";
        do {
        	System.out.print("Enter Citation Category: ");
            cc = scanner.nextLine();
            scanner.nextLine();
            ccid = getCitationCategoryIdFromCitationCategory(conn, cc);
        } while (ccid == "");
        
        System.out.print("Enter Car License Number: ");
        String cln = scanner.nextLine();
        scanner.nextLine();
        
        System.out.print("Enter Parking Lot ID: ");
        String pl = scanner.nextLine();
        scanner.nextLine();
        
        int plid = Integer.valueOf(pl);

        System.out.print("Enter ZoneID: ");
        String zid = scanner.nextLine();
        scanner.nextLine();
        
        System.out.print("Enter Space Number: ");
        String sn = scanner.nextLine();
        
        int sno = Integer.valueOf(sn);

        String insertSQL = "INSERT INTO Citations"
        		+ "(CitationNumber, CitationDate, CitationTime, PaymentStatus, CitationCategoryID, CarLicenseNumber, ParkingLotID, ZoneID, SpaceNumber) "
        		+ "VALUES (?, ?, ?, 'Unpaid', ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
        	pstmt.setString(1, cnumber);
            pstmt.setString(2, cdt);
            pstmt.setString(3, ctm);
            pstmt.setString(4, ccid);
            pstmt.setString(5, cln);
            pstmt.setInt(6, plid);
            pstmt.setString(7, zid);
            pstmt.setInt(8, sno);

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Citation inserted successfully!\n");
            } else {
                System.out.println("Failed to insert citation.\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	// Update Citation
	 private static void updateCitation(Connection conn,Scanner scanner) {
		 System.out.println("Existing data from Citations");
			try {
				selectCitation(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		scanner.nextLine();
		System.out.print("Enter Citation Number: ");
	    String sn = scanner.nextLine();
	        
	    String cc = "";
        String ccid = "";
        do {
        	System.out.print("Enter Citation Category: ");
            cc = scanner.nextLine();
            ccid = getCitationCategoryIdFromCitationCategory(conn, cc);
        } while (ccid == "");
        
        System.out.print("Enter Citation Date (YYYY-MM-DD): ");
        String cdt = scanner.nextLine();
        
        System.out.print("Enter Citation Time (HH:MM:SS): ");
        String ctm = scanner.nextLine();

        System.out.print("Enter Payment Status (Paid/Unpaid): ");
        String ps = scanner.nextLine();

        String SQL = "UPDATE Citations "
        		+ "SET CitationCategoryID = ?, CitationDate = ?,"
        		+ "CitationTime = ?, PaymentStatus = ? "
        		+ "WHERE CitationNumber = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setString(1, ccid);
            pstmt.setString(2, cdt);
            pstmt.setString(3, ctm);
            pstmt.setString(4, ps);
            pstmt.setString(5, sn);

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Citation updated successfully!\n");
            } else {
                System.out.println("Failed to update citation.\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
	 }
	 
	 //Delete Citation
	 public static void deleteCitation(Connection connection, Scanner scanner) {
		   try {
			   	scanner.nextLine();
		       System.out.print("Enter the Citation Number to delete: ");
		       String citationNumberToDelete = scanner.nextLine();
		       
		       String deleteQuery = "DELETE FROM Citations WHERE CitationNumber = ?";
		       try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
		           preparedStatement.setString(1, citationNumberToDelete);
		           int rowsAffected = preparedStatement.executeUpdate();
		           if (rowsAffected > 0) {
		               System.out.println("Citation with number " + citationNumberToDelete + " deleted successfully.");
		           } else {
		               System.out.println("No citation found with number " + citationNumberToDelete);
		           }
		       } catch (SQLException e) {
		           e.printStackTrace();
		       }
		   } catch (Exception e) {
		       e.printStackTrace();
		   }
		}

	 /* 
		Security will create/update/delete citations to vehicles that violate parking regulations; 
		required information for generating a citation is described above. 
		Payment status of a citation will be changed from unpaid to paid by invoking a payment procedure.
	*/
	  //Add Payment
	 	 private static void insertPayment(Connection conn,Scanner scanner) {    
	     	 System.out.print("Enter Payment Date (YYYY-MM-DD): ");
	          String pdt = scanner.next();
	          
	          System.out.print("Enter Payment Time (HH:MM:SS): ");
	          String ptm = scanner.next();
	          
	          System.out.print("Enter Citation Number: ");
	          String c = scanner.next();
	          
	          Float amt= (float) 0.0;
	 		 String SQL = "Select Fee from CitationCategories CC JOIN Citations C "
	 		 		+ "ON C.CitationCategoryID=CC.CitationCategoryID where C.CitationNumber = ?;";
	 		
	 		 System.out.println(SQL);
	     	 try (PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
	     		 preparedStatement.setString(1, c);
	              try (ResultSet resultSet = preparedStatement.executeQuery()) {
	                  while (resultSet.next()) {
	                      amt = resultSet.getFloat("Fee");
	                  }
	              }
	 		 } catch (SQLException e1) {
	 			// TODO Auto-generated catch block
	 			e1.printStackTrace();
	 		}
	 		 
	         String insertSQL = "INSERT INTO Payments (PaymentID, PaymentDate, PaymentTime, Amount, CitationNumber) "
	         		+ "VALUES (NULL, ?, ?, ?, ?);";

	         try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
	 			//Set Auto commit to false to create a successful transaction 
	 			connection.setAutoCommit(false);
	             pstmt.setString(1, pdt);
	             pstmt.setString(2, ptm);
	             pstmt.setFloat(3, amt);
	             pstmt.setString(4, c);

	             int rowsAffected = pstmt.executeUpdate();

	             if (rowsAffected > 0) {
	                 System.out.println("Payment inserted successfully! Updating Payment Status. \n");
	                 updatePaymentStatus(conn, scanner, c, 0);
	             } else {
	                 System.out.println("Failed to insert Payment.\n");
	             }

	 			pstmt.close();
	 			connection.commit();

	         } catch (SQLException e) {
	             e.printStackTrace();

	 			if (connection!= null){
	 				try{
	 					System.out.println("Transaction is being roll-backed");
	 					conn.rollback();
	 				}catch(SQLException s){
	 					s.printStackTrace();
	 				}
	         }
	         }
	 		finally{
	 			try{
	 	            // Enable auto-commit after the transaction
	 	            connection.setAutoCommit(true);
	 		       }catch(SQLException s){
	 				s.printStackTrace();
	 				}
	 	        }
	 	 }
	 
	 //Delete Payment
	 private static void deletePayment(Connection conn,Scanner scanner) {  
         
         System.out.print("Enter Payment ID: ");
         String c = scanner.nextLine();
        
         int pid = Integer.valueOf(c);
         
        String SQL = "DELETE FROM Payments WHERE PaymentID = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setInt(1, pid);

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Payment deleted successfully!\n");
            } else {
                System.out.println("Failed to delete Payment.\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
	 }

	 //Add Appeal - Pending by default
	 private static void insertAppeal(Connection conn,Scanner scanner) { 
		 scanner.nextLine();
     	System.out.print("Enter Appeal Description: ");
         String ad = scanner.nextLine();
         scanner.nextLine();
      
         
         System.out.print("Enter Citation Number: ");
         String c = scanner.nextLine();
         scanner.nextLine();
         
         int cno = Integer.valueOf(c);

         String insertSQL = "INSERT INTO Appeals (AppealID, AppealDescription, AppealStatus, CitationNumber) "
         		+ "VALUES (NULL, ?, 'Pending', ?)";

         try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
             pstmt.setString(1, ad);
             pstmt.setInt(2, cno);

             int rowsAffected = pstmt.executeUpdate();

             if (rowsAffected > 0) {
                 System.out.println("Appeal inserted successfully!\n");
             } else {
                 System.out.println("Failed to insert Appeal.\n");
             }
         } catch (SQLException e) {
             e.printStackTrace();
         }
	}

	 //Update Appeal Status
	 private static void updateAppealStatus(Connection conn,Scanner scanner) {    
         
		 System.out.print("Enter Appeal ID: ");
         String aid = scanner.next();
         int ano = Integer.valueOf(aid);
		 
         System.out.print("Enter Appeal Status (Approved/Pending/Rejected): ");
         String as = scanner.next();

         String SQL = "UPDATE Appeals "
         		+ "SET AppealStatus = ? WHERE AppealID = ?;";
         

         try (PreparedStatement pstmt = conn.prepareStatement(SQL)) {
			// Set the auto commit to false for the grouping the methods under one successful transaction
			conn.setAutoCommit(false);

        	 Integer flag = 0;
             if(as.equals("Approved"))
             {
            	 flag=1;
             }
             String a=aid;
             pstmt.setString(1, as);
             pstmt.setInt(2, ano);
             int rowsAffected = pstmt.executeUpdate();

             if (rowsAffected > 0) {
                 System.out.println(" Appeal Status updated successfully!\n");
                 
                 if(flag==1)
                 {
                	 Integer cc=0;
                	 String sql= "select CitationNumber from Appeals where AppealID = ?";
                	 System.out.println(sql);
                	 try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                		 preparedStatement.setString(1, a);
                         try (ResultSet resultSet = preparedStatement.executeQuery()) {
                             while (resultSet.next()) {
                                 cc = resultSet.getInt("CitationNumber");
                             }
                         }
                     
             			String cn = String.valueOf(cc);
                	 updatePaymentStatus(conn, scanner, cn, 1);
                 }
             }
             }
             else {
                 System.out.println("Failed to update Appeal Status.\n");
             }

			 pstmt.close();
			 conn.commit();

         
         }catch (SQLException e) {
             e.printStackTrace();
			 //If the connection is not null then the transaction has to be roll-backed
			 if (conn!= null){
				try{
					System.out.println("Transaction is being roll-backed");
					conn.rollback();
				}catch(SQLException s){
					s.printStackTrace();
				}
			}
         }
		 finally{
			try{
	            // Enable auto-commit after the transaction
	            conn.setAutoCommit(true);
		       }catch(SQLException s){
				s.printStackTrace();
				}
	        }
	}

	 //Update Appeal Status
	 private static void updatePaymentStatus(Connection conn,Scanner scanner, String CitationID, Integer flag) {    
			try {
				selectSpace(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		 
		 //flag = 0 -> Payment  flag = 1 -> Appeal Successful
		 String SQL = "";
         if(flag == 0)
         {
        	 System.out.println("\n"+CitationID+"\n");
			 SQL = "UPDATE Citations "
	         		+ "SET PaymentStatus = 'Paid' WHERE CitationNumber = ?;";
			 System.out.println(SQL);
         }
         if(flag == 1)
         {
        	 System.out.println("\n"+CitationID+"\n");
			 SQL = "UPDATE Citations "
	         		+ "SET PaymentStatus = 'Waived Off' WHERE CitationNumber = ?;";
			 System.out.println(SQL);
         }
         try (PreparedStatement pstmt = conn.prepareStatement(SQL)) {
             pstmt.setString(1, CitationID);

             int rowsAffected = pstmt.executeUpdate();

             if (rowsAffected > 0) {
                 System.out.println("Payment Status updated successfully!\n");
             } else {
                 System.out.println("Failed to update Payment Status.\n");
             }
         } catch (SQLException e) {
             e.printStackTrace();
         }
	}
	 
	  // Delete Appeal
	  private static void deleteAppeal(Connection conn,Scanner scanner) {    
      	System.out.print("Enter Appeal ID: ");
          String c = scanner.nextLine();
        
          int aid = Integer.valueOf(c);
          

          String SQL = "DELETE FROM Appeals WHERE AppealID = ?";

          try (PreparedStatement pstmt = conn.prepareStatement(SQL)) {
              pstmt.setInt(1, aid);

              int rowsAffected = pstmt.executeUpdate();

              if (rowsAffected > 0) {
                  System.out.println("Appeal deleted successfully!\n");
              } else {
                  System.out.println("Failed to delete Appeal.\n");
              }
          } catch (SQLException e) {
              e.printStackTrace();
          }
	}
	
	  // Update Citation Category ID
	  private static void updateCitationCategoryID(Connection conn,Scanner scanner) {
		  System.out.println("Existing data from Citations");
			try {
				selectCitation(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		scanner.nextLine();
		  System.out.print("Enter Citation Number: ");
          String sn = scanner.nextLine();
          
          String cc = "";
          String ccid = "";
          do {
          	System.out.print("Enter Citation Category: ");
              cc = scanner.nextLine();
              ccid = getCitationCategoryIdFromCitationCategory(conn, cc);
          } while (ccid == "");
          
          String SQL = "UPDATE Citations SET CitationCategoryID = ? "
          		+ "WHERE CitationNumber =?;";

          try (PreparedStatement pstmt = conn.prepareStatement(SQL)) {
              pstmt.setString(1, ccid);
              pstmt.setString(2, sn);

              int rowsAffected = pstmt.executeUpdate();
              scanner.nextLine();
              if (rowsAffected > 0) {
                  System.out.println("Citaiton Category ID updated successfully!\n");
              } else {
                  System.out.println("Failed to update Citation Category ID.\n");
              }
          } catch (SQLException e) {
              e.printStackTrace();
          }
	}

	  
	  // Add Citation Category
	  private static void insertCitationCategory(Connection conn,Scanner scanner) {    
      	System.out.print("Enter Citation Category: ");
      	scanner.nextLine();  
      	String cc = scanner.nextLine();
      	scanner.nextLine();

          System.out.print("Enter Fee: ");
          String a = scanner.nextLine();
          float fee = Float.valueOf(a);

          String insertSQL = "INSERT INTO CitationCategories (CitationCAtegoryID, CitationCategory, Fee) VALUES (NULL, ?, ?)";

          try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
              pstmt.setString(1, cc);
              pstmt.setFloat(2, fee);

              int rowsAffected = pstmt.executeUpdate();

              if (rowsAffected > 0) {
                  System.out.println("Citaiton Category inserted successfully!\n");
              } else {
                  System.out.println("Failed to insert Citation Category.\n");
              }
          } catch (SQLException e) {
              e.printStackTrace();
          }
	  }
 
	 
	 // Update Citation Category
	  private static void updateCitationCategory(Connection conn,Scanner scanner) {
		  System.out.println("Existing data from Citation Categories");
			try {
				selectCitationCategory(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		  System.out.print("Enter Citation Category ID: ");
		  int ccid = scanner.nextInt();
          
          System.out.print("Enter Citation Category: ");
          scanner.nextLine();
          String cc = scanner.nextLine();

          System.out.print("Enter Fee: ");
          String a = scanner.nextLine();
          float fee = Float.valueOf(a);
          
          String SQL = "UPDATE CitationCategories SET CitationCategory = ?, Fee = ? WHERE CitationCategoryID = ?;";

          try (PreparedStatement pstmt = conn.prepareStatement(SQL)) {

              pstmt.setString(1, cc);
              pstmt.setFloat(2, fee);
              pstmt.setInt(3, ccid);

              int rowsAffected = pstmt.executeUpdate();

              if (rowsAffected > 0) {
                  System.out.println("Citaiton Category updated successfully!\n");
              } else {
                  System.out.println("Failed to update Citation Category.\n");
              }
          } catch (SQLException e) {
              e.printStackTrace();
          }
	}


//***************************************************************************************************************************
	
// TASK AND OPERATIONS : 4 : REPORTS
	  
	  //Generate report to return all citations
	  public static void generateReportForCitations() {
		    String sql = "SELECT c.CitationNumber, c.CitationDate, c.CitationTime, c.PaymentStatus, cc.CitationCategory, c.CarLicenseNumber, pl.Name AS ParkingLotName, c.ZoneID, c.SpaceNumber "
		            + "FROM Citations c JOIN CitationCategories cc JOIN ParkingLots pl ON c.ParkingLotID = pl.ParkingLotID and c.CitationCategoryID = cc.CitationCategoryID";
		    try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
		        ResultSet result = pstmt.executeQuery();
		        if (result.next()) {
		            do {
		                System.out.println("CitationNumber: " + result.getString("CitationNumber"));
		                System.out.println("CitationDate: " + result.getDate("CitationDate"));
		        		System.out.println("CitationTime: " + result.getTime("CitationTime"));
		        		System.out.println("PaymentStatus: " + result.getString("PaymentStatus"));
		        		System.out.println("CitationCategory: " + result.getString("CitationCategory"));
		        		System.out.println("CarLicenseNumber: " + result.getString("CarLicenseNumber"));
		        		System.out.println("ParkingLotName: " + result.getString("ParkingLotName"));
		        		System.out.println("ZoneID: " + result.getString("ZoneID"));
		        		System.out.println("SpaceNumber: " + result.getInt("SpaceNumber") + "\n");
		            } while (result.next());
		        } else {
		            System.out.println("No records to display.");
		        }
		        connection.commit();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}
	  
	  //Create citation reports in a given time range for all zones in each lot
	  public static void generateCitationReportInTimeRange(Connection conn,Scanner sc) {
		    System.out.println("Enter start date for report: ");
      		String startDate = sc.next();
      		System.out.println("Enter end date for report: ");
      		String endDate = sc.next();

      	
			String sql = "SELECT c.ParkingLotID, p.Name, p.Address , COUNT(*) "
					+ "FROM Citations c JOIN ParkingLots p ON c.ParkingLotID = p.ParkingLotID "
					+ "WHERE c.CitationDate BETWEEN ? AND ? "
					+ "GROUP BY c.ParkingLotID, p.Name, p.Address"; 
			   
		    try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
		    	pstmt.setString(1, startDate);
		    	pstmt.setString(2,  endDate);
		        ResultSet result = pstmt.executeQuery();
		        if (result.next()) {
		        	do {
		        		System.out.println("ParkingLotID: " + result.getInt("ParkingLotID"));
		        		System.out.println("Name: " + result.getString("Name"));
		        		System.out.println("Address: " + result.getString("Address"));
		        		System.out.println("CitationCount: " + result.getInt("COUNT(*)") + "\n");
		        	} while (result.next());
		        }
		        else {
		        	System.out.println("No records to display.");
		        }
		        connection.commit();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}

	  //Generate report showing zones along with their corresponding parking lots as tuple
	  public static void generateParkingLotAndZones() {
			String sql = "SELECT ParkingLotID, ZoneID "
					+ "FROM Zones "
					+ "ORDER BY ParkingLotID, ZoneID"; 
			   
		    try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
		        ResultSet result = pstmt.executeQuery();
		        if (result.next()) {
		        	do {
		        		System.out.println("ParkingLotID: " + result.getInt("ParkingLotID"));
		        		System.out.println("ZoneID: " + result.getString("ZoneID") + "\n");
		        	} while (result.next());
		        }
		        else {
		        	System.out.println("No records to display.");
		        }
		        connection.commit();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}
	  
	  //Generate report to give active citation violation count
	  public static void generateActiveCitationViolationCount() {
			String sql = "SELECT COUNT(DISTINCT CarLicenseNumber) AS CitationViolationCount "
					+ "FROM Citations "
					+ "WHERE PaymentStatus = 'Unpaid'"; 
			   
		    try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
		        ResultSet result = pstmt.executeQuery();
		        if (result.next()) {
		        	System.out.println("CitationViolationCount: " + result.getInt("CitationViolationCount") + "\n");
		        }
		        else {
		        	System.out.println("No records to display.");
		        }
		        connection.commit();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}

	  	//Generate report to get number of employees having permits for a given parking zone
	  public static void generateNoOfEmployeesWithPermitsInZone(Connection conn,Scanner sc) {
		  System.out.println("Enter Parking Lot ID: ");
      	  int parkingLotId = sc.nextInt();
      	  System.out.println("Enter Zone ID : ");
      	  String zoneId = sc.next();

			String sql = "SELECT COUNT(*) AS EmployeeCount "
					+ "FROM Permits P JOIN Drivers D ON P.UID_Phone = D.UID_Phone "
					+ "WHERE D.Status = 'E' AND ParkingLotID = ? AND ZoneID = ?"; 
			   
		    try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
		    	pstmt.setInt(1, parkingLotId);
		    	pstmt.setString(2,  zoneId);
		        ResultSet result = pstmt.executeQuery();
		        if (result.next()) {
		        	System.out.println("EmployeeCount: " + result.getInt("EmployeeCount"));
		        }
		        else {
		        	System.out.println("No records to display.");
		        }
		        connection.commit();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}
	  
	  //Generate report to get permit information for given UID_Phone
	  public static void generatePermitInfoForUser(Connection conn, Scanner sc) {
		    System.out.println("Enter UID_Phone ");
		    long uid_Phone = sc.nextLong();
		    String sql = "SELECT p.PermitID, p.StartDate, p.ExpirationDate, p.ExpirationTime, pt.PermitType, pl.Name AS ParkingLotName, p.ZoneID, st.SpaceType, p.UID_Phone, p.CarLicenceNumber "
		            + "FROM Permits p JOIN PermitTypes pt JOIN SpaceTypes st JOIN ParkingLots pl ON p.PermitTypeID = pt.PermitTypeID AND p.SpaceTypeID = st.SpaceTypeID AND p.ParkingLotID = pl.ParkingLotID "
		            + "WHERE UID_Phone = ?";
		    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
		        pstmt.setLong(1, uid_Phone);
		        ResultSet result = pstmt.executeQuery();
		        if (result.next()) {
		            do {
		                System.out.println("PermitID: " + result.getString("PermitID"));
		                System.out.println("StartDate: " + result.getDate("StartDate"));
		                System.out.println("ExpirationDate: " + result.getDate("ExpirationDate"));
		                System.out.println("ExpirationTime: " + result.getTime("ExpirationTime"));
		                System.out.println("PermitType: " + result.getString("PermitType"));
		                System.out.println("ParkingLotName: " + result.getString("ParkingLotName"));
		                System.out.println("ZoneID: " + result.getString("ZoneID"));
		                System.out.println("SpaceType: " + result.getString("SpaceType"));
		                System.out.println("UID_Phone: " + result.getString("UID_Phone"));
		                System.out.println("CarLicenceNumber: " + result.getString("CarLicenceNumber") + "\n");
		            } while (result.next());
		        } else {
		            System.out.println("No records to display.");
		        }
		        conn.commit();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}
	  
	  //Generate report to get an available space number in a given parking lot for a given space type
	  public static void generateAvailableSpaceInLot (Connection conn,Scanner sc) {
			System.out.println("Enter Parking Lot ID: ");
	      	int parkingLotId = sc.nextInt();
	      	System.out.println("Enter Space Type : ");
	      	String spaceType = sc.next();
		  
			String sql = "SELECT SpaceNumber "
					+ "FROM Spaces S JOIN SpaceTypes ST ON S.SpaceTypeID = ST.SpaceTypeID WHERE ParkingLotID = ? AND  SpaceType = ? AND AvailabilityStatus = 'Available' LIMIT 1"; 
			   
		    try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
		    	pstmt.setInt(1, parkingLotId);
		    	pstmt.setString(2, spaceType);
		        ResultSet result = pstmt.executeQuery();
		        if (result.next()) {
		        	System.out.println("Available SpaceNumber: " + result.getInt("SpaceNumber"));
		        }
		        else {
		        	System.out.println("No records to display.");
		        }
		        connection.commit();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}

//***************************************************************************************************************************

	
//Connect to Database
	private static void connectToDatabase() throws ClassNotFoundException, SQLException {
		Class.forName("org.mariadb.jdbc.Driver");
	
		String user = "jpradee";
		String password = "200538654";
	
		connection = DriverManager.getConnection(jdbcURL, user, password);
		statement = connection.createStatement();
		if(statement != null)
		{
			System.out.println("Connected");
		}
		else
		{
			System.out.println("Cannot Connect");
		}
}

//Close the connection 
	private static void close() {
		if (connection != null) {
			try {
				connection.close();
				System.out.println("Connection Closed");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (result != null) {
			try {
				result.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}


}
