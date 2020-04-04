package action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

	public static void main(String[] args) {

		List<Node> root = new ArrayList<Node>();
		List<Node> allNode = new ArrayList<Node>();
		List<Serivce> service = new ArrayList<Serivce>();

		Map<String, Integer> serviceMap = new HashMap<String, Integer>();
		for (Serivce s : service) {
			serviceMap.put(s.getNodeId(), s.getCount());
		}

		for (Node rt : root) {

			buildChildren(rt, allNode, 0, serviceMap);

		}

	}

	private static int buildChildren(Node rt, List<Node> allNode, int i,
			Map<String, Integer> serviceMap) {
		List<Node> children = new ArrayList<Node>();
		int count = i;
		for (Node temN : allNode) {
			if (temN.getPid().equals(rt.getId())) {
				if (serviceMap.containsKey(temN.getId())) {
					temN.setCount(serviceMap.get(temN.getId()));
					count = count + serviceMap.get(temN.getId());
				}
				count = buildChildren(temN, allNode, count, serviceMap);
				children.add(temN);
			}
		}
		rt.setChildren(children);
		rt.setCount(count);
		return count;

	}

}
