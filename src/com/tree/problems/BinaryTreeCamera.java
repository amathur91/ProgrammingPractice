package com.tree.problems;

import java.util.*;

public class BinaryTreeCamera {
   private static int totalNodes = 0;
   private static double maxHeight = 0;
    public int minCameraCover(TreeNode root) {
        if(root == null){
            totalNodes = 0;
            maxHeight = 0;
            return 0;
        }else if(root != null && isALeafNode(root)){
            totalNodes = 0;
            maxHeight = 0;
            return 1;
        }
        ArrayList<Integer> sequenceList = new ArrayList<>();
        Queue<TreeNode> processingQueue = new LinkedList<>();
        processingQueue.add(root);
        doBFS(processingQueue, sequenceList);
        heightOfTree(root, 0);
        int[] arrayInput = new int[(int) (Math.pow(2,maxHeight + 1 ))];
        buildArray(arrayInput, sequenceList);
        boolean[] coverageStatus = new boolean[arrayInput.length];
        int minCoverageCost = findTheMinCameraCost(arrayInput, 0, 0, coverageStatus, 0);
        totalNodes = 0;
        maxHeight = 0;
        return minCoverageCost;
    }

    private void buildArray(int[] arrayInput, ArrayList<Integer> sequenceList) {
        for(Integer num : sequenceList){
            if (num != -1){
                arrayInput[num] = 1;
            }
        }
        for(int index = 1; index < arrayInput.length; index++){
            if(arrayInput[index] == 0){
                arrayInput[index] = -1;
            }
        }
    }

    private void heightOfTree(TreeNode node, int height){
        if(node != null){
            if(height > maxHeight){
                maxHeight = height;
            }
            heightOfTree(node.left, height + 1);
            heightOfTree(node.right, height + 1);
        }
    }
    private int findTheMinCameraCost(int[] input, int index, int cameraCount, boolean[] coverageStatus, int coverage){
        if(index < input.length){
            if(input[index] == -1){
                return findTheMinCameraCost(input, index + 1, cameraCount, coverageStatus, coverage);
            }else{
                if(coverageStatus[index]){
                    return findTheMinCameraCost(input, index + 1, cameraCount, coverageStatus, coverage);
                }else{
                    //either place camera or dont place it
                    int additionalCoverage = placeCamera(coverageStatus, index, input, true);
                    int placeCamera = findTheMinCameraCost(input, index + 1, cameraCount + 1, coverageStatus, coverage + additionalCoverage);

                    //remove the camera

                    placeCamera(coverageStatus, index, input, false);
                    if((2*index + 1 ) < input.length ) {
                        Arrays.fill(coverageStatus, (2*index + 1), coverageStatus.length, false);
                    }
                    int withOutCamera = findTheMinCameraCost(input, index + 1, cameraCount, coverageStatus, coverage);
                    return Math.min(placeCamera, withOutCamera);
                }
            }
        }
        if(coverage != totalNodes){
            return cameraCount + Math.abs((totalNodes - coverage));
        }
        return cameraCount;
    }

    private int placeCamera(boolean[] coverageStatus, int startIndex, int[] sequenceList, boolean doPlace){
           int coverage = 0;
            coverageStatus[startIndex] = doPlace;
            if(doPlace){
                coverage++;
            }else{
                coverage--;
            }
            //check for parent
            int parentIndex = getParent(startIndex);
            int leftChildIndex = startIndex * 2 + 1;
            int rightChildIndex = startIndex * 2 + 2;
            if (parentIndex >= 0 && parentIndex < sequenceList.length && !coverageStatus[parentIndex]) {
                coverageStatus[parentIndex] = doPlace;
                if(doPlace){
                    coverage++;
                }else{
                    coverage--;
                }
            }
            if (leftChildIndex >= 0 && leftChildIndex < sequenceList.length && sequenceList[leftChildIndex] != -1) {
                coverageStatus[leftChildIndex] = doPlace;
                if(doPlace){
                    coverage++;
                }else{
                    coverage--;
                }
            }

            if (rightChildIndex >= 0 && rightChildIndex < sequenceList.length && sequenceList[rightChildIndex] != -1) {
                coverageStatus[rightChildIndex] = doPlace;
                if(doPlace){
                    coverage++;
                }else{
                    coverage--;
                }
            }
            return coverage;
        }

    private int getParent(int startIndex) {
        if(startIndex % 2 == 0){
            return (startIndex - 2) / 2;
        }
        return (startIndex - 1) / 2;
    }

    private void doBFS(Queue<TreeNode> processingQueue, ArrayList<Integer> sequenceList) {

        while(!processingQueue.isEmpty()){
            TreeNode node = processingQueue.poll();
            sequenceList.add(node.val);
            if(node.val != -1) {
                totalNodes++;
                if (node.left == null) {
                    processingQueue.add(new TreeNode(-1));
                } else {
                    node.left.val = node.val * 2 +1;
                    processingQueue.add(node.left);
                }

                if (node.right == null) {
                    processingQueue.add(new TreeNode(-1));
                } else {
                    node.right.val = node.val * 2 + 2;
                    processingQueue.add(node.right);
                }
            }
        }
    }

    private boolean isALeafNode(TreeNode root) {
        return root.left == null && root.right == null;
    }
}
