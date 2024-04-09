package kh.edu.teamfit;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class ExerciseCart implements ExerciseInterface {
	public ArrayList<Exercise> exerciselist = new ArrayList<Exercise>();
	public static int exerciseCount = 0; //

	public void saveUserExerciseData(String userName) {
		try {
			loadAllUserExerciseData();
			BufferedWriter writer = new BufferedWriter(new FileWriter("UserExercise.txt"));
			for (Exercise exercise : exerciselist) {
				writer.write(userName + "," + exercise.getClassCode() + "," + exercise.getName() + ","
						+ exercise.getLocation() + "," + exercise.getDate() + "," + exercise.getMemNum() + ","
						+ exercise.getTeacherName() + "," + exercise.getPrice() + "/");

			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 파일에서 사용자의 운동 정보를 불러오는 메서드
	public void loadUserExerciseData(String userName) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("UserExercise.txt"));
			String line;
			while ((line = reader.readLine()) != null) {
				String[]userExerciseData = line.split("/");
				for(String data : userExerciseData) {
					String[] parts = data.split(",");
					if(parts[0].equals(userName)) {
						String code = parts[1];
						String name = parts[2];
						String location = parts[3];
						String date = parts[4];
						int memnum = Integer.parseInt(parts[5]);
						String teachername = parts[6];
						int price = Integer.parseInt(parts[7]);
						
						exerciselist.add(new Exercise(code, name, location, date, memnum, teachername, price));
					}
				}
				
			

				
			}
			reader.close();
		} catch (FileNotFoundException e) {

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public void loadAllUserExerciseData() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("UserExercise.txt"));
			String line;
			while ((line = reader.readLine()) != null) {
				String[]userExerciseData = line.split("/");
				for(String data : userExerciseData) {
					String[] parts = data.split(",");
					 
						String code = parts[1];
						String name = parts[2];
						String location = parts[3];
						String date = parts[4];
						int memnum = Integer.parseInt(parts[5]);
						String teachername = parts[6];
						int price = Integer.parseInt(parts[7]);
						
						exerciselist.add(new Exercise(code, name, location, date, memnum, teachername, price));
					
				}
				
			

				
			}
			reader.close();
		} catch (FileNotFoundException e) {

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public boolean isCartInExercise(String id) {
		return false;
	}

	@Override
	public void printExerciseList(ArrayList<Exercise> exerciselist) {
		for (int i = 0; i < exerciselist.size(); i++) {
			Exercise exercise = exerciselist.get(i);
			System.out.println(exercise.getClassCode());
			System.out.println(exercise.getName());
			System.out.println(exercise.getLocation());
			System.out.println(exercise.getDate());
			System.out.println(exercise.getMemNum());
			System.out.println(exercise.getTeacherName());
			System.out.println(exercise.getPrice());

		}
	}

	@Override
	public void insertExercise(Exercise exercise) {
		if (exerciselist.contains(exercise)) {
			System.out.println("이미 신청한 항목입니다.");
		} else {
			exerciselist.add(exercise);
			exerciseCount = exerciselist.size();
			System.out.println("운동이 성공적으로 추가되었습니다");
		}

	}

	@Override
	public void removeCart(String classCode) {

		for (Iterator<Exercise> iterator = exerciselist.iterator(); iterator.hasNext();) {
			Exercise exercise = iterator.next();
			if (exercise.getClassCode().equals(classCode)) {
				iterator.remove();
				System.out.println("운동이 성공적으로 삭제되었습니다.");
				return;
			}
		}

		System.out.println("해당 과목 코드에 해당하는 운동이 존재하지 않습니다.");
	}

	@Override
	public void delAllExercise() {
		exerciselist.clear();
		exerciseCount = 0;

	}

	public ArrayList<String> getExerciseCodes() {
		ArrayList<String> codes = new ArrayList<>();
		for (Exercise exercise : exerciselist) {
			codes.add(exercise.getClassCode());
		}
		return codes;
	}

	public void printCart() {
		System.out.println("내 운동  목록");
		System.out.println("===================================================");
		System.out.println("\t강의코드\t|이름\t|장소\t|날짜\t|인원 수\t|");

		for (int i = 0; i < exerciselist.size(); i++) {
			System.out.print("\t" + exerciselist.get(i).getClassCode() + "\t|");
			System.out.print(exerciselist.get(i).getName() + "\t|");
			System.out.print(exerciselist.get(i).getLocation() + "\t|");
			System.out.print(exerciselist.get(i).getDate() + "\t|");
			System.out.print(exerciselist.get(i).getMemNum() + "\t|");
			System.out.println();
		}
		System.out.println("===================================================");

	}

}
