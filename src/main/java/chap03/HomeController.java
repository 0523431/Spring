package chap03;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// 컨테이너에 homeController라는 이름의 객체가 생성되고 저장됨
@Component
public class HomeController {
	private AlarmDevice alarmDevice;
	private Viewer viewer;
	
	// 이름으로 객체를 주입할 수 있게 해줌
	// 이름을 기준으로 주입
	@Resource(name="camera1") // number값이 1
	private Camera camera1;
	@Resource(name="camera2")
	private Camera camera2;
	@Resource(name="camera3")
	private Camera camera3;
	@Resource(name="camera4")
	private Camera camera4;
	
	private List<InfraredRaySensor> sensors;
	
	// (required=false) : Recorder객체가 없으면 null로 주입 == 에러가 나지않게 함 
	@Autowired(required=false)
	private Recorder recorder;
	
	// 컨테이너에서 AlarmDevice객체와 Viewer객체
	// 자료형을 기준으로 주입
	@Autowired
	public void prepare(AlarmDevice alarmDevice, Viewer viewer) {
		this.alarmDevice = alarmDevice;
		this.viewer = viewer;
	}
	
	// 객체 생성시, 모든 객체의 주입이 완료된 후 (객체 생성 이후)
	// 다 끝나야 출력이 됨
	@PostConstruct
	public void init() {
		System.out.println("<<<<<<<init() 메서드 호출>>>>>>>");
		viewer.add(camera1);
		viewer.add(camera2);
		viewer.add(camera3);
		viewer.add(camera4);
		viewer.draw();
	}
	
	// @Autowired : 자료형을 기준으로 객체주입
	// @Qualifier : "별명"만 가져와 ==> xml에서 <qualifier value="intrusionDetection" /> 부분
	@Autowired
	@Qualifier("intrusionDetection")
	public void setSensors(List<InfraredRaySensor> sensors) {
		System.out.println("<<<<<<<setSensors() 메서드 호출>>>>>>>");
		this.sensors = sensors;
		for(InfraredRaySensor s : sensors) {
			System.out.println("센서 등록 : " + s);
		}
	}
	public void checkSensorAndAlarm() {
		for(InfraredRaySensor s : sensors) {
			if(s.isObjectFounded()) {
				alarmDevice.alarm(s.getName());
			}
		}
	}
}
/*
	기본 어노테이션
	1. 객체생성 : @Component
		<context:component-scan base-package="chap03" />
	
	2. 객체주입
		@Autowired : 객체선택의 기준이 클래스의 자료형
					 (required=false) 객체가 없는 경우 null로 보내서 에러없이 가능하게 해줌
		@Resource : 객체 중 이름에 해당하는 객체를 주입
		@Required : 객체선택의 기준이 클래스의 자료형이나 반드시 객체가 필요함
		
	3. 그외
		@PostConstruct : 객체주입까지 끝난 즉, 객체생성이 완료된 후 호출되는 메서드 위에 설정
		@Qualifier : 객체의 이름에 별명을 설정 @Autowired와 함꼐 사용됨
						<qualifier value="intrusionDetection" />
		@Scope(..) : 생성된 객체의 지속가능한 영역 설정 (일회용) @Component와 함꼐 사용됨
*/