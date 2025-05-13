package tetris;

/**
 * �ĸ񷽿���
 * @author Leslie Leung
 */
public class Tetromino {
	// commit 1
	// commit 2
	// commit 3
	protected Cell[] cells;		//�ö�������cells�洢�ĸ񷽿�
	protected Cell axis;	//��ת��
	protected Cell[] rotateCells;	//��Ҫ��ת�ĸ��Ӽ���
	/**
	 * ʵ���ĸ񷽿���ʱ��ת���㷨
	 * @param axis ��ת�ᣬ��cells���±�Ϊ0��CellΪ��ת��
	 * @param rotateCells Ҫ��ת�ĸ��ӵļ���
	 */
	protected void anticlockwiseRotate(Cell axis, Cell[] rotateCells) {
		int oldX;	//���Ա�ʾ��������rotateCell�ĺ�����
		int oldY;	//���Ա�ʾ��������rotateCell��������
		int newX;	//���Ա�ʾ��������rotateCell��ת��ĺ�����
		int newY;	//���Ա�ʾ��������rotateCell��ת���������
		
		for(int i = 0; i < 3; i ++) {
			oldX = rotateCells[i].getX();
			oldY = rotateCells[i].getY();
			
			newX = axis.getX() - axis.getY() + oldY;	//�º���������㷨
			newY = axis.getY() + axis.getX() - oldX;	//������������㷨
			
			rotateCells[i].setX(newX);		//��������Ŀ����ӵĺ�����
			rotateCells[i].setY(newY);		//��������Ŀ����ӵ�������
		}
	}
	
	/**
	 * ʵ���ĸ񷽿�˳ʱ��ת���㷨
	 * @param axis ��ת�ᣬ��cells���±�Ϊ0��CellΪ��ת��
	 * @param rotateCells Ҫ��ת�ĸ��ӵļ���
	 */
	protected void clockwiseRotate(Cell axis, Cell[] rotateCells) {
		int oldX;	//���Ա�ʾ��������rotateCell�ĺ�����
		int oldY;	//���Ա�ʾ��������rotateCell��������
		int newX;	//���Ա�ʾ��������rotateCell��ת��ĺ�����
		int newY;	//���Ա�ʾ��������rotateCell��ת���������
		
		for(int i = 0; i < 3; i ++) {
			oldX = rotateCells[i].getX();
			oldY = rotateCells[i].getY();
			
			newX = axis.getX() - oldY + axis.getY();	//�º���������㷨
			newY = axis.getY() + oldX - axis.getX();	//������������㷨
			
			rotateCells[i].setX(newX);		//��������Ŀ����ӵĺ�����
			rotateCells[i].setY(newY);		//��������Ŀ����ӵ�������
		}
	}
	
	/**
	 * ʵ���ĸ񷽿���Զ�����
	 */
	protected void softDrop() {
		int oldY;	//ĳ����������ǰ��������
		int newY;	//ĳ������������������
		
		/* ���и������� */
		for(int i = 0; i < cells.length; i ++) {
			oldY = cells[i].getY();
			newY = oldY + 1;
			
			cells[i].setY(newY);
		}
	}
	
	/**
	 * ʵ���ĸ񷽿����Ƶ��㷨
	 */
	protected void moveLeft() {
		int oldX;	//ĳ����������ǰ�ĺ�����
		int newX;	//ĳ���������ƺ�ĺ�����
		
		/* ���и������� */
		for(int i = 0; i < cells.length; i ++) {
			oldX = cells[i].getX();
			newX = oldX - 1;
			
			cells[i].setX(newX);
		}
	}
	
	/**
	 * ʵ���ĸ񷽿����Ƶ��㷨
	 */
	protected void moveRight() {
		int oldX;	//ĳ����������ǰ�ĺ�����
		int newX;	//ĳ���������ƺ�ĺ�����
		
		/* ���и������� */
		for(int i = 0; i < cells.length; i ++) {
			oldX = cells[i].getX();
			newX = oldX + 1;
			
			cells[i].setX(newX);
		}
	}
	
	/**
	 * �����ĸ񷽿�ĸ��ӵļ���
	 * @return Cell�ļ���
	 */
	protected Cell[] getCells() {
		return cells;
	}
	
	/**
	 * ��ȡ��ת��
	 * @return ��ת��
	 */
	protected Cell getAxis() {
		return axis;
	}
	
	/**
	 * ��ȡ��Ҫ��ת��Ŀ����ӵļ���
	 * @return Ŀ����ӵļ���
	 */
	protected Cell[] getRotateCells() {
		return rotateCells;
	}
	
	/**
	 * ��cells[0]����Ϊ��ת��
	 */
	protected void setAxis() {
		axis = cells[0];
	}
	
	/**
	 * �½�����Ϊ3�����鲢��cells[1]��cells[2]��cells[3]��ӵ�rotateCells��
	 */
	protected void setRotateCells() {
		rotateCells = new Cell[]{cells[1], cells[2], cells[3]};
	}
}
