package com.korchagin.courses.task9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class SearchMax extends RecursiveTask<Integer> {
    private int[] data;
//    private int max;

    public SearchMax(int[] data) {
        this.data = data;
    }

//    public int getMax() {
//        return max;
//    }

    @Override
    protected Integer compute() {
        if (this.data.length > 2) {
            List<SearchMax> subtasks = createSubtasks();
            for (SearchMax subtask : subtasks) {
                subtask.fork();
            }
            int max = data[0];
//            max = data[0];
            for (SearchMax subtask : subtasks) {
                int temp = subtask.join();
                if (temp > max) {
                    max = temp;
                }
            }
            return max;
        } else {
            int max = data[0];
            for (int i = 1; i < data.length; i++) {
                if (data[i] > max) {
                    max = data[i];
                }
            }
            return max;
        }
    }


    private List<SearchMax> createSubtasks() {
        return new ArrayList<>(Arrays.asList(
                new SearchMax(Arrays.copyOfRange(data, 0, data.length/2)),
                new SearchMax(Arrays.copyOfRange(data, data.length/2, data.length))
        ));
    }
}
